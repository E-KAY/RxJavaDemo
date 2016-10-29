package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import java.util.concurrent.TimeUnit;

import rx.Observable;

/**
 * Observable_throttleLast
 * <p>
 * Created by HuangYK on 16/10/27.
 */
public class MainListWithExample_Observable_throttleLast extends MainListWithExample_Observable {

    public MainListWithExample_Observable_throttleLast() {
        addExample(example1());
        addExample(example2());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_throttleLast_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_throttleLast;
    }

    private Observable example1() {
        return Observable.interval(200, TimeUnit.MILLISECONDS).take(10).sample(550, TimeUnit.MILLISECONDS);
    }

    private Observable example2() {
        return Observable.interval(200, TimeUnit.MILLISECONDS).take(10).throttleLast(550, TimeUnit.MILLISECONDS);
    }


}
