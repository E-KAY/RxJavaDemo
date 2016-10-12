package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import rx.Observable;
import rx.Subscriber;

/**
 * Observable_onExceptionResumeNext
 * <p>
 * Created by HuangYK on 16/10/3.
 */
public class MainListWithExample_Observable_onExceptionResumeNext extends MainListWithExample_Observable {

    public MainListWithExample_Observable_onExceptionResumeNext() {
        addExample(example1());
        addExample(example2());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_onExceptionResumeNext_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_onExceptionResumeNext;
    }

    private Observable example1() {
        // onErrorReturn(Func1<? super Throwable, ? extends T> resumeFunction)

        Observable<Integer> observable = getObservable1();
        return observable.onExceptionResumeNext(Observable.just(101));
    }

    private Observable example2() {
        // onErrorReturn(Func1<? super Throwable, ? extends T> resumeFunction)

        Observable<Integer> observable = getObservable2();
        return observable.onExceptionResumeNext(Observable.just(101));
    }


    private Observable<Integer> getObservable1() {
        return Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                if (subscriber.isUnsubscribed()) {
                    return;
                }
                try {
                    for (int i = 0; i < 10; i++) {
                        if (i == 4) {
                            // 如果这里抛出的 不是 Exception 类型的异常，就不会捕获
                            throw new Error("401");
                        }
                        subscriber.onNext(i);
                    }
                    subscriber.onCompleted();
                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        });
    }

    private Observable<Integer> getObservable2() {
        return Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                if (subscriber.isUnsubscribed()) {
                    return;
                }
                try {
                    for (int i = 0; i < 10; i++) {
                        if (i == 4) {
                            // 如果这里抛出的 不是 Exception 类型的异常，就不会捕获
                            throw new Exception("401");
                        }
                        subscriber.onNext(i);
                    }
                    subscriber.onCompleted();
                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        });
    }

}


