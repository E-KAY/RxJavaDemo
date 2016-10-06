package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import java.util.concurrent.TimeUnit;

import rx.Observable;

/**
 * Observable_interval
 * <p/>
 * Created by HuangYK on 16/10/3.
 */
public class MainListWithExample_Observable_interval extends MainListWithExample_Observable {

    public MainListWithExample_Observable_interval() {
        addExample(example1());
        addExample(example2());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_interval_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_interval;
    }


    private Observable example1() {
        return Observable.interval(1, TimeUnit.SECONDS).take(5);
    }

    private Observable example2() {
        // Observable<Long> interval(long initialDelay, long period, TimeUnit unit)
        // 初次延迟 1秒，之后延迟2秒
        return Observable.interval(1, 2, TimeUnit.SECONDS).take(5);
    }
}
