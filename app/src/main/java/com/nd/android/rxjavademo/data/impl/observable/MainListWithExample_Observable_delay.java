package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;

/**
 * Observable_delay
 * <p/>
 * Created by HuangYK on 16/10/3.
 */
public class MainListWithExample_Observable_delay extends MainListWithExample_Observable {

    public MainListWithExample_Observable_delay() {
        addExample(example1());
        addExample(example2());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_delay_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_delay;
    }

    private Observable example1() {
        return Observable.create(getOnSubscribe(2)).delay(2000, TimeUnit.MILLISECONDS);
    }

    private Observable example2() {
        return Observable.create(getOnSubscribe(2)).delaySubscription(2000, TimeUnit.MILLISECONDS);
    }

    private Observable.OnSubscribe<Long> getOnSubscribe(final int index) {
        return new Observable.OnSubscribe<Long>() {
            @Override
            public void call(Subscriber<? super Long> subscriber) {
                for (int i = 1; i <= index; i++) {
                    subscriber.onNext(System.currentTimeMillis());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
    }


}
