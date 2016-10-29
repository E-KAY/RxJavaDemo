package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;

/**
 * Observable_throttleWithTimeout
 * <p>
 * Created by HuangYK on 16/10/27.
 */
public class MainListWithExample_Observable_throttleWithTimeout extends MainListWithExample_Observable {

    public MainListWithExample_Observable_throttleWithTimeout() {
        addExample(example1());
        addExample(example2());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_throttleWithTimeout_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_throttleWithTimeout;
    }

    private Observable example1() {
        // debounce

        return Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                if (subscriber.isUnsubscribed()) return;
                try {
                    //产生结果的间隔时间分别为100、200、300...900毫秒
                    for (int i = 1; i < 10; i++) {
                        Thread.sleep(i * 100);
                        subscriber.onNext(i);
                    }
                    subscriber.onCompleted();
                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        }).debounce(400, TimeUnit.MILLISECONDS);
    }

    private Observable example2() {
        // throttleWithTimeout

        return Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                if (subscriber.isUnsubscribed()) return;
                try {
                    //产生结果的间隔时间分别为100、200、300...900毫秒
                    for (int i = 1; i < 10; i++) {
                        subscriber.onNext(i);
                        Thread.sleep(i * 100);
                    }
                    subscriber.onCompleted();
                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        }).throttleWithTimeout(400, TimeUnit.MILLISECONDS);
    }

}
