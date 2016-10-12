package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * Observable_onErrorResumeNext
 * <p>
 * Created by HuangYK on 16/10/3.
 */
public class MainListWithExample_Observable_onErrorResumeNext extends MainListWithExample_Observable {

    public MainListWithExample_Observable_onErrorResumeNext() {
        addExample(example1());
        addExample(example2());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_onErrorResumeNext_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_onErrorResumeNext;
    }

    private Observable example1() {
        // onErrorResumeNext(Observable)

        Observable<Integer> observable = getObservable();
        return observable.onErrorResumeNext(Observable.just(101));
    }

    private Observable example2() {
        Observable<Integer> observable = getObservable();

        return observable.onErrorResumeNext(new Func1<Throwable, Observable<? extends Integer>>() {
            @Override
            public Observable<? extends Integer> call(Throwable throwable) {
                if ("401".equals(throwable.getMessage())) {
                    return Observable.just(102);
                }
                return null;
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


