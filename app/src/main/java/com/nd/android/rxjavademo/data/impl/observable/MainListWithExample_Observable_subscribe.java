package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import rx.Observable;
import rx.Observer;
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
        Observable.just("")
                .compose(this.<String>applySchedulers())
                .subscribe();
    }

    private void example2() {
        // Subscription subscribe(Action1)
        // 只对onNext发送的数据进行处理
        Observable.just("")
                .compose(this.<String>applySchedulers())
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {

                    }
                });
    }

    private void example3() {
        // Subscription subscribe(Action1, Action1)
        // 对 onNext 和 onError 发送的数据进行处理
        Observable.just("")
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
        // Subscription subscribe(Action1, Action1, Action0)
        // 对 onNext、onError、onCompleted 发送的数据进行处理
        Observable.just("")
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
        // Subscription subscribe(Subscriber)
        // 对 onNext、onError、onCompleted 发送的数据进行处理
        Observable.just("")
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

    private void example6() {
        // Subscription subscribe(Observer)
        // 对 onNext、onError、onCompleted 发送的数据进行处理
        Observable.just("")
                .compose(this.<String>applySchedulers())
                .subscribe(new Observer<String>() {
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
