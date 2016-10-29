package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import java.util.concurrent.TimeUnit;

import rx.Observable;

/**
 * Observable_throttleFirst
 * <p>
 * Created by HuangYK on 16/10/27.
 */
public class MainListWithExample_Observable_throttleFirst extends MainListWithExample_Observable {

    public MainListWithExample_Observable_throttleFirst() {
        addExample(example1());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_throttleFirst_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_throttleFirst;
    }

    private Observable example1() {
        return Observable.interval(0, 300, TimeUnit.MILLISECONDS).take(5).throttleFirst(600, TimeUnit.MILLISECONDS);
    }


}
