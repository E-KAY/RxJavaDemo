package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import java.util.concurrent.TimeUnit;

import rx.Observable;

/**
 * Observable_skipLast
 * <p>
 * Created by HuangYK on 16/10/25.
 */
public class MainListWithExample_Observable_skipLast extends MainListWithExample_Observable {

    public MainListWithExample_Observable_skipLast() {
        addExample(example1());
        addExample(example2());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_skipLast_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_skipLast;
    }

    private Observable example1() {
        return Observable.range(1, 10).skipLast(5);
    }

    private Observable example2() {
        return Observable.interval(100, TimeUnit.MILLISECONDS).take(10).skipLast(500, TimeUnit.MILLISECONDS);
    }
}


