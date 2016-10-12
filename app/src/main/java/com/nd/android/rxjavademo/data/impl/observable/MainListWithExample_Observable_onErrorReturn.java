package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * Observable_onErrorReturn
 * <p>
 * Created by HuangYK on 16/10/3.
 */
public class MainListWithExample_Observable_onErrorReturn extends MainListWithExample_Observable {

    public MainListWithExample_Observable_onErrorReturn() {
        addExample(example1());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_onErrorReturn_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_onErrorReturn;
    }

    private Observable example1() {
        // onErrorReturn(Func1<? super Throwable, ? extends T> resumeFunction)

        Observable<Integer> observable = getObservable();
        return observable.onErrorReturn(new Func1<Throwable, Integer>() {
            @Override
            public Integer call(Throwable throwable) {
                return 101;
            }
        });
    }


    private Observable<Integer> getObservable() {
        return Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                if (subscriber.isUnsubscribed()) {
                    return;
                }

                try {
                    for (int i = 0; i < 10; i++) {
                        if (i == 4) {
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

}


