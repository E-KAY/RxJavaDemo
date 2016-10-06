package com.nd.android.rxjavademo.data.impl.observable;

import android.support.annotation.NonNull;

import com.nd.android.rxjavademo.R;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Observable_compose
 * <p/>
 * Created by HuangYK on 16/10/3.
 */
public class MainListWithExample_Observable_compose extends MainListWithExample_Observable {


    public MainListWithExample_Observable_compose() {
//        addExample(example1());
//        addExample(example2());
//        addExample(example3());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_compose_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_compose;
    }

    private void example1() {

        // ugly 写法，这种写法违反Rx 的链式结构。。。
        doSubscribe(applySchedulers(Observable.just(1, 2, 3, 4, 5)));
    }


    private void example2() {
        // elegant 写法，以链式形式展现，流程清晰、明确。

        Observable.just(1, 2, 3, 4, 5)
                .compose(this.<Integer>applySchedulers())
                .subscribe(this.<Integer>getSubscriber());
    }

    @SuppressWarnings("unchecked")
    private void example3() {
        Observable.just(1, 2, 3, 4, 5)
                .compose(this.<Integer>applySchedulers())
                .subscribe((Observer<? super Integer>) new ApplySchedulers());
    }


    // 专门用来指定在工作线程中处理数据，在主线程中订阅...
    // 事实上写其实很 ugly，这打破了Rx  链式的概念
    // Deprecated it...
    private <T> Observable<T> applySchedulers(Observable<T> observable) {
        return observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    // Deprecated it...
    private <T> Subscription doSubscribe(@NonNull Observable<T> observable) {
        return observable
                .subscribe(new Subscriber<T>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(T result) {
                    }
                });
    }


    // 这个写法才能保持Rx 链式的结构，通过compose...
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

    private <T> Subscriber<T> getSubscriber() {
        return new Subscriber<T>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onNext(T result) {
            }
        };
    }

    private class ApplySchedulers<T> implements Observable.Transformer<T, T> {
        @Override
        public Observable<T> call(Observable<T> observable) {
            return observable
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread());
        }
    }

}
