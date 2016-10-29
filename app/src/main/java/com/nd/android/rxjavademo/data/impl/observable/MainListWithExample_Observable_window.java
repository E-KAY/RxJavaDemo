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
 * Observable_window
 * <p>
 * Created by HuangYK on 16/10/27.
 */
public class MainListWithExample_Observable_window extends MainListWithExample_Observable {

    public MainListWithExample_Observable_window() {
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
        addExample(example12());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_window_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_window;
    }

    private Observable example1() {
        return Observable.range(1, 6).window(2);
    }

    private Observable example2() {
        return Observable.range(1, 6).window(6);
    }

    private Observable example3() {
        return Observable.range(1, 6).window(2, 3);
    }

    private Observable example4() {
        return Observable.range(1, 6).window(3, 2);
    }

    private Observable example5() {
        return Observable.interval(100, TimeUnit.MILLISECONDS)
                .take(10).window(250, TimeUnit.MILLISECONDS);
    }

    private Observable example6() {
        return Observable.interval(100, TimeUnit.MILLISECONDS)
                .take(10).window(250, TimeUnit.MILLISECONDS, 2);
    }

    private Observable example7() {
        return Observable.interval(100, TimeUnit.MILLISECONDS)
                .take(10).window(350, 200, TimeUnit.MILLISECONDS);
    }

    private Observable example8() {
        return Observable.interval(100, TimeUnit.MILLISECONDS)
                .take(10).buffer(200, 350, TimeUnit.MILLISECONDS);
    }

    private Observable example9() {
        return Observable.interval(100, TimeUnit.MILLISECONDS)
                .take(10).window(450, 300, TimeUnit.MILLISECONDS, 2, Schedulers.io());
    }

    private Observable example10() {
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
        }).window(new Func0<Observable<?>>() {
            @Override
            public Observable<?> call() {
                return Observable.interval(300, TimeUnit.MILLISECONDS);
            }
        });
    }

    private Observable example11() {
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
        }).window(
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
//                .window(
//                        Observable.interval(250, TimeUnit.MILLISECONDS),
//                        new Func1<Long, Observable<?>>() {
//                            @Override
//                            public Observable<?> call(Long aLong) {
//                                return Observable.timer(200, TimeUnit.MILLISECONDS);
//                            }
//                        });
    }

    private Observable example12() {

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
        }).window(Observable.create(new Observable.OnSubscribe<Long>() {
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
