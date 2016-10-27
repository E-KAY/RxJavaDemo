package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;
import com.nd.android.rxjavademo.utils.RxJavaDemoUtils;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action0;

/**
 * Observable_serialize
 * <p>
 * Created by HuangYK on 16/10/25.
 */
public class MainListWithExample_Observable_serialize extends MainListWithExample_Observable {

    public MainListWithExample_Observable_serialize() {
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_serialize_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_serialize;
    }

    private void example1() {
        Observable<Integer> source = Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                subscriber.onNext(1);
                subscriber.onNext(2);
                subscriber.onCompleted();
                subscriber.onNext(3);
                subscriber.onCompleted();
            }
        });

        source.doOnUnsubscribe(new Action0() {
            @Override
            public void call() {
                RxJavaDemoUtils.LogW("Unsubscribe");
            }
        }).unsafeSubscribe( // 重点在这个订阅符
                new Subscriber<Integer>() {
                    @Override
                    public void onCompleted() {
                        RxJavaDemoUtils.LogW("onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        RxJavaDemoUtils.LogW("onError");
                    }

                    @Override
                    public void onNext(Integer t) {
                        RxJavaDemoUtils.LogW("onNext: " + t);
                    }
                }

        );
        // 在这种情况下，输出的结果为：
        // onNext: 1
        // onNext: 2
        // onCompleted
        // onNext: 3
        // onCompleted

        // 如果加上serialize 就会变为正常的：
        // onNext: 1
        // onNext: 2
        // onCompleted
    }

}


