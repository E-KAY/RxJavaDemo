package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import rx.Observable;
import rx.Subscriber;

/**
 * Observable_ignoreElements
 * <p/>
 * Created by HuangYK on 16/10/3.
 */
public class MainListWithExample_Observable_ignoreElements extends MainListWithExample_Observable {

    public MainListWithExample_Observable_ignoreElements() {
        addExample(example1());
        addExample(example2());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_ignoreElements_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_ignoreElements;
    }


    private Observable example1() {
        return Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                subscriber.onNext(1);
                subscriber.onNext(2);
                subscriber.onNext(3);
                subscriber.onCompleted();
            }
        }).ignoreElements();
    }

    private Observable example2() {
        return Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                subscriber.onNext(1);
                subscriber.onNext(2);
                subscriber.onNext(3);
                subscriber.onError(new Throwable());
            }
        }).ignoreElements();
    }


}
