package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import java.util.concurrent.TimeUnit;

import rx.Observable;

/**
 * Observable_sample
 * <p>
 * Created by HuangYK on 16/10/24.
 */
public class MainListWithExample_Observable_sample extends MainListWithExample_Observable {

    public MainListWithExample_Observable_sample() {
        addExample(example1());
        addExample(example2());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_sample_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_sample;
    }

    private Observable example1() {
        return Observable.interval(200, TimeUnit.MILLISECONDS).take(10).sample(550, TimeUnit.MILLISECONDS);
    }

    private Observable example2() {
        return Observable.interval(200, TimeUnit.MILLISECONDS).take(10).sample(Observable.interval(550, TimeUnit.MILLISECONDS));
    }
}


