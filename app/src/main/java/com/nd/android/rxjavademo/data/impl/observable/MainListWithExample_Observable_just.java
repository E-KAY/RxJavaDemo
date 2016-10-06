package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import rx.Observable;

/**
 * Observable_just
 * <p/>
 * Created by HuangYK on 16/10/3.
 */
public class MainListWithExample_Observable_just extends MainListWithExample_Observable {

    public MainListWithExample_Observable_just() {
        addExample(example1());
        addExample(example2());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_just_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_just;
    }

    private Observable example1() {
        // 目前最多可以有10个参数
        return Observable.just("One");
    }

    private Observable example2() {
        return Observable.just("One", "Two");
    }
}
