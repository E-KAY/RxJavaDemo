package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import rx.Observable;
import rx.Subscriber;

/**
 * Observable_timeInterval
 * <p>
 * Created by HuangYK on 16/10/27.
 */
public class MainListWithExample_Observable_timeInterval extends MainListWithExample_Observable {

    public MainListWithExample_Observable_timeInterval() {
        addExample(example1());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_timeInterval_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_timeInterval;
    }

    private Observable example1() {

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
        }).timeInterval();
    }


}
