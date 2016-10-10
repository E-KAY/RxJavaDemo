package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Observable_subscribe
 * <p>
 * Created by HuangYK on 16/10/3.
 */
public class MainListWithExample_Observable_subscribe extends MainListWithExample_Observable {

    public MainListWithExample_Observable_subscribe() {
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_subscribe_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_subscribe;
    }

    private void example1() {
        // 最基本的，直接订阅，对Observable发送的数据不进行处理
        // Subscription subscribe()
        Observable.create(getOnSubscribe1())
                .compose(this.<String>applySchedulers())
                .subscribe();
    }

    private void example2() {
        // Subscription subscribe(final Action1<? super T> onNext)
        // 只对onNext发送的数据进行处理
        Observable.create(getOnSubscribe2())
                .compose(this.<String>applySchedulers())
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {

                    }
                });
    }

    private void example3() {
        // Subscription subscribe(final Action1<? super T> onNext, final Action1<Throwable> onError)
        // 对 onNext 和 onError 发送的数据进行处理
        Observable.create(getOnSubscribe3())
                .compose(this.<String>applySchedulers())
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {

                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {

                    }
                });
    }

    private void example4() {
        // Subscription subscribe(final Action1<? super T> onNext, final Action1<Throwable> onError, final Action0 onCompleted)
        // 对 onNext、onError、onCompleted 发送的数据进行处理
        Observable.create(getOnSubscribe3())
                .compose(this.<String>applySchedulers())
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {

                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {

                    }
                }, new Action0() {
                    @Override
                    public void call() {

                    }
                });
    }

    private void example5() {
        // Subscription subscribe(Subscriber<? super T> subscriber)
        // 对 onNext、onError、onCompleted 发送的数据进行处理
        Observable.create(getOnSubscribe3())
                .compose(this.<String>applySchedulers())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String s) {

                    }
                });
    }

    private Observable.OnSubscribe<String> getOnSubscribe1() {
        return new Observable.OnSubscribe<String>() {

            @Override
            public void call(Subscriber<? super String> subscriber) {
                try {
                    Thread.sleep(500);
                    subscriber.onNext("One");
                    Thread.sleep(500);
                    subscriber.onNext("Two");
                    Thread.sleep(500);
                    subscriber.onNext("Three");
                    Thread.sleep(500);
                    subscriber.onCompleted();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private Observable.OnSubscribe<String> getOnSubscribe2() {
        // 触发 onCompleted，之后的代码不会继续执行
        return new Observable.OnSubscribe<String>() {

            @Override
            public void call(Subscriber<? super String> subscriber) {
                try {
                    Thread.sleep(500);
                    subscriber.onNext("One");
                    Thread.sleep(500);
                    subscriber.onNext("Two");
                    Thread.sleep(500);
                    subscriber.onCompleted();
                    Thread.sleep(500);
                    subscriber.onNext("Three");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private Observable.OnSubscribe<String> getOnSubscribe3() {
        // 触发 onError，之后的代码不会继续执行
        return new Observable.OnSubscribe<String>() {

            @Override
            public void call(Subscriber<? super String> subscriber) {
                try {
                    Thread.sleep(500);
                    subscriber.onNext("One");
                    Thread.sleep(500);
                    subscriber.onNext("Two");
                    Thread.sleep(500);
                    subscriber.onError(new Throwable());
                    Thread.sleep(500);
                    subscriber.onNext("Three");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private <T> Observable.Transformer<T, T> applySchedulers() {
        return new Observable.Transformer<T, T>() {
            @Override
            public Observable<T> call(Observable<T> tObservable) {
                return tObservable
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }
}
