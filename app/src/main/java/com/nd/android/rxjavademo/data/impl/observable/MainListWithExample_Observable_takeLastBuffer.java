package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import java.util.concurrent.TimeUnit;

import rx.Observable;

/**
 * Observable_takeLastBuffer
 * <p>
 * Created by HuangYK on 16/10/26.
 */
public class MainListWithExample_Observable_takeLastBuffer extends MainListWithExample_Observable {

    public MainListWithExample_Observable_takeLastBuffer() {
        addExample(example1());
        addExample(example2());
        addExample(example3());
        addExample(example4());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_takeLastBuffer_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_takeLastBuffer;
    }

    private Observable example1() {
        return Observable.just(1, 2, 3, 4, 5, 6, 10, 11, 12, 13).takeLastBuffer(3);
    }

    private Observable example2() {
        return Observable.interval(0, 100, TimeUnit.MILLISECONDS).take(20).takeLastBuffer(1000, TimeUnit.MILLISECONDS);
    }

    private Observable example3() {
        return Observable.interval(0, 100, TimeUnit.MILLISECONDS).take(20).takeLastBuffer(2, 1000, TimeUnit.MILLISECONDS);
    }

    private Observable example4() {
        return Observable.interval(0, 100, TimeUnit.MILLISECONDS).take(10).takeLastBuffer(5, 250, TimeUnit.MILLISECONDS);
    }
}
