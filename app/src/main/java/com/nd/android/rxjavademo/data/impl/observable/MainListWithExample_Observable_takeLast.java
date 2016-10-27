package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import java.util.concurrent.TimeUnit;

import rx.Observable;

/**
 * Observable_takeLast
 * <p>
 * Created by HuangYK on 16/10/26.
 */
public class MainListWithExample_Observable_takeLast extends MainListWithExample_Observable {

    public MainListWithExample_Observable_takeLast() {
        addExample(example1());
        addExample(example2());
        addExample(example3());
        addExample(example4());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_takeLast_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_takeLast;
    }

    private Observable example1() {
        return Observable.just(1, 2, 3, 4, 5, 6, 10, 11, 12, 13).takeLast(3);
    }

    private Observable example2() {
        return Observable.interval(0, 100, TimeUnit.MILLISECONDS).take(20).takeLast(1000, TimeUnit.MILLISECONDS);
    }

    private Observable example3() {
        return Observable.interval(0, 100, TimeUnit.MILLISECONDS).take(20).takeLast(2, 1000, TimeUnit.MILLISECONDS);
    }

    private Observable example4() {
        return Observable.interval(0, 100, TimeUnit.MILLISECONDS).take(10).takeLast(5, 250, TimeUnit.MILLISECONDS);
    }
}
