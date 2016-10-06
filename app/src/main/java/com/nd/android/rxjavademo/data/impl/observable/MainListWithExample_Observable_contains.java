package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import rx.Observable;

/**
 * Observable_contains
 * <p/>
 * Created by HuangYK on 16/10/3.
 */
public class MainListWithExample_Observable_contains extends MainListWithExample_Observable {


    public MainListWithExample_Observable_contains() {
        addExample(example1());
        addExample(example2());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_contains_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_contains;
    }

    private Observable example1() {
        return Observable.just(1, 2, 3, 4, 5).contains(1);
    }


    private Observable example2() {
        return Observable.just(1, 2, 3, 4, 5).contains(6);
    }
}
