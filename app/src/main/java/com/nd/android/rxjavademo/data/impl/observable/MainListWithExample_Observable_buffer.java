package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Observable_buffer
 * <p/>
 * Created by HuangYK on 16/10/3.
 */
public class MainListWithExample_Observable_buffer extends MainListWithExample_Observable {


    public MainListWithExample_Observable_buffer() {
        addExample(example1());
        addExample(example2());
        addExample(example3());
        addExample(example4());
        addExample(example5());
        addExample(example6());
        addExample(example7());
        addExample(example8());
        addExample(example9());
        addExample(example10());
        addExample(example11());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_buffer_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_buffer;
    }

    private Observable example1() {

        // buffer(int count)
        return Observable.range(1, 6).buffer(2);
    }

    private Observable example2() {

        // buffer(int count)
        return Observable.range(1, 6).buffer(6);
    }

    private Observable example3() {

        // buffer(int count, int skip)

        // 每隔3个数据开始一个缓冲，每次缓冲2个数据，所以每次第三个数据都被丢弃了。
        // 当 count < skip 的时候，缓冲的数据有丢失
        return Observable.range(1, 6).buffer(2, 3);
    }

    private Observable example4() {

        // buffer(int count, int skip)

        // 每隔2个数据开始一个缓冲，每次缓冲3个数据，所以每次第三个数据都是重复的
        //当 count > skip 的时候，缓冲的数据重叠了
        return Observable.range(1, 6).buffer(3, 2);

        // 当 count = skip 的时候，则是和和前面 Example1、Example2等效，不举例了
    }

    private Observable example5() {

        // buffer(long timespan, TimeUnit unit)

        // 用时间做条件
        return Observable.interval(100, TimeUnit.MILLISECONDS)
                .take(10).buffer(250, TimeUnit.MILLISECONDS);

        // 写法2：
//        return Observable.interval(100, TimeUnit.MILLISECONDS)
//                .take(10).buffer(Observable.interval(250, TimeUnit.MILLISECONDS));
        // 写法3：
//        return Observable.interval(100, TimeUnit.MILLISECONDS)
//                .take(10).buffer(250, TimeUnit.MILLISECONDS, Schedulers.computation());
    }

    private Observable example6() {

        // buffer(long timespan, TimeUnit unit, int count)

        // 同时用数目和时间作为缓冲条件，任意一个条件满足了（缓冲的个数达到了或者当前时间窗口结束了），就发射缓冲里的数据。
        // 这里会看到发射了很多空的数据。这是应为，发射了2个数据后，达到了数目缓冲的要求，就触发了一次发射数据的操作，
        // 然后规定时间到了又触发了时间缓冲的条件，这个时候还没有新的数据发射，所以就触发一个空的列表发射出来。
        return Observable.interval(100, TimeUnit.MILLISECONDS)
                .take(10).buffer(250, TimeUnit.MILLISECONDS, 2);
    }

    private Observable example7() {


        // buffer(long timespan, long timeshift, TimeUnit unit)

        // 当 timespan > timeshift 的时候，缓冲的数据重叠了
        // 每隔 200毫秒开启下一个缓冲，每个缓冲时间窗口是 350毫秒。所以两个缓冲之间会有 150毫秒的重叠。
        return Observable.interval(100, TimeUnit.MILLISECONDS)
                .take(10).buffer(350, 200, TimeUnit.MILLISECONDS);
    }

    private Observable example8() {

        // buffer(long timespan, long timeshift, TimeUnit unit)
        // 当 timespan < timeshift 的时候，缓冲的数据有丢失
        // 每隔 350 毫秒开启下一个缓冲，每个缓冲时间窗口是 200 毫秒。所以两个缓冲之间会有 150毫秒的丢失。
        return Observable.interval(100, TimeUnit.MILLISECONDS)
                .take(10).buffer(200, 350, TimeUnit.MILLISECONDS);

        // 当 timespan = timeshift 的时候，和 Example5 等效，不举例了
    }

    private Observable example9() {
        // buffer(Func0<? extends Observable<? extends TClosing>> bufferClosingSelector)
        // 自己定义一个Observer，来决定什么时候停止收集流
        return Observable.create(new Observable.OnSubscribe<Long>() {
            @Override
            public void call(Subscriber<? super Long> subscriber) {
                long i = 0;
                while (i < 100) {
                    try {
                        i++;
                        subscriber.onNext(i);
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                subscriber.onCompleted();
            }
        }).buffer(new Func0<Observable<?>>() {
            @Override
            public Observable<?> call() {
                return Observable.interval(300, TimeUnit.MILLISECONDS);
            }
        });
    }

    private Observable example10() {
        // buffer(bufferOpenings, bufferClosingSelector), 很强大，但是一般用得不多
        // 第一个 bufferOpenings 参数为一个 Observable，只要该 Observable 发射了一个数据，就开始一个新的缓冲。
        // 每个缓冲到的数据会传递给第二个函数参数 bufferClosingSelector ，bufferClosingSelector 参数为一个函数，
        // 该函数创建一个新的 Observable，当这个 Observable 发射数据的时候表明这个缓冲结束。
        return Observable.create(new Observable.OnSubscribe<Long>() {
            @Override
            public void call(Subscriber<? super Long> subscriber) {
                long i = 0;
                while (i < 100) {
                    try {
                        Thread.sleep(100);
                        i++;
                        subscriber.onNext(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                subscriber.onCompleted();
            }
        }).buffer(
                Observable.create(new Observable.OnSubscribe<Long>() {
                    @Override
                    public void call(final Subscriber<? super Long> subscriber) {
                        final Scheduler.Worker worker = Schedulers.io().createWorker();
                        subscriber.add(worker);
                        worker.schedulePeriodically(new Action0() {
                            long counter = 100;

                            @Override
                            public void call() {
                                try {
                                    subscriber.onNext(counter++);
                                } catch (Throwable e) {
                                    try {
                                        worker.unsubscribe();
                                    } finally {
                                        Exceptions.throwOrReport(e, subscriber);
                                    }
                                }
                            }
                        }, 250, 250, TimeUnit.MILLISECONDS);
                    }
                }),
                new Func1<Long, Observable<Long>>() {
                    @Override
                    public Observable<Long> call(final Long aLong) {
                        return Observable.create(new Observable.OnSubscribe<Long>() {
                            @Override
                            public void call(Subscriber<? super Long> subscriber) {
                                try {
                                    Thread.sleep(200);
                                    subscriber.onNext(aLong);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                });

        // 底下这个写法等效于上面这段代码
//        return Observable.interval(100, TimeUnit.MILLISECONDS).take(10)
//                .buffer(
//                        Observable.interval(250, TimeUnit.MILLISECONDS),
//                        new Func1<Long, Observable<?>>() {
//                            @Override
//                            public Observable<?> call(Long aLong) {
//                                return Observable.timer(200, TimeUnit.MILLISECONDS);
//                            }
//                        });
    }

    private Observable example11() {

        // 自己定义一个Observer，来决定什么时候停止收集流
        return Observable.create(new Observable.OnSubscribe<Long>() {
            @Override
            public void call(Subscriber<? super Long> subscriber) {
                long i = 0;
                while (i < 100) {
                    try {
                        i++;
                        subscriber.onNext(i);
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                subscriber.onCompleted();
            }
        }).buffer(Observable.create(new Observable.OnSubscribe<Long>() {
            @Override
            public void call(final Subscriber<? super Long> subscriber) {
                final Scheduler.Worker worker = Schedulers.io().createWorker();
                subscriber.add(worker);
                worker.schedulePeriodically(new Action0() {
                    long counter = 100;

                    @Override
                    public void call() {
                        try {
                            subscriber.onNext(counter++);
                        } catch (Throwable e) {
                            try {
                                worker.unsubscribe();
                            } finally {
                                Exceptions.throwOrReport(e, subscriber);
                            }
                        }
                    }
                }, 250, 250, TimeUnit.MILLISECONDS);
            }

        }));
    }


}
