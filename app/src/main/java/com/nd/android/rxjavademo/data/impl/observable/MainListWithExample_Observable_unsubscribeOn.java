package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;
import com.nd.android.rxjavademo.utils.RxJavaDemoUtils;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/**
 * Observable_unsubscribeOn
 * <p>
 * Created by HuangYK on 16/10/27.
 */
public class MainListWithExample_Observable_unsubscribeOn extends MainListWithExample_Observable {

    public MainListWithExample_Observable_unsubscribeOn() {
        addExample(example1());
        addExample(example2());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_unsubscribeOn_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_unsubscribeOn;
    }

    private Observable example1() {
        return mSource.doOnUnsubscribe(new Action0() {
            @Override
            public void call() {
                RxJavaDemoUtils.threadInfo("doOnUnsubscribe");
            }
        }).unsubscribeOn(Schedulers.io());

    }

    private Observable example2() {
        return mSource.doOnUnsubscribe(new Action0() {
            @Override
            public void call() {
                RxJavaDemoUtils.threadInfo("doOnUnsubscribe");
            }
        });

    }

    Observable<Integer> mSource = Observable.create(new Observable.OnSubscribe<Integer>() {
        @Override
        public void call(Subscriber<? super Integer> subscriber) {
            subscriber.onNext(1);
            subscriber.onNext(2);
            subscriber.onCompleted();
            subscriber.onNext(3);
            subscriber.onCompleted();
        }
    });
}
