package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import java.util.concurrent.TimeUnit;

import rx.Observable;

/**
 * Observable_skip
 * <p>
 * Created by HuangYK on 16/10/25.
 */
public class MainListWithExample_Observable_skip extends MainListWithExample_Observable {

    public MainListWithExample_Observable_skip() {
        addExample(example1());
        addExample(example2());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_skip_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_skip;
    }

    private Observable example1() {
        return Observable.range(1, 10).skip(5);
    }

    private Observable example2() {
        return Observable.interval(100, TimeUnit.MILLISECONDS).take(10).skip(300, TimeUnit.MILLISECONDS);
    }
}


