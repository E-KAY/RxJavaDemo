package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import java.util.concurrent.TimeUnit;

import rx.Observable;

/**
 * Observable_limit
 * <p>
 * Created by HuangYK on 16/10/3.
 */
public class MainListWithExample_Observable_limit extends MainListWithExample_Observable {

    public MainListWithExample_Observable_limit() {
        addExample(example1());
        addExample(example2());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_limit_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_limit;
    }

    private Observable example1() {
        return Observable.interval(300, TimeUnit.MILLISECONDS).limit(10);
    }

    private Observable example2() {
        return Observable.just(1, 2, 3, 4, 5).limit(8);
    }

}
