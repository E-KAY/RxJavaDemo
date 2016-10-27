package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import java.util.concurrent.TimeUnit;

import rx.Observable;

/**
 * Observable_cache
 * <p>
 * Created by HuangYK on 16/10/3.
 */
public class MainListWithExample_Observable_cache extends MainListWithExample_Observable {

    private Observable cacheObservable;

    public MainListWithExample_Observable_cache() {
        addExample(example1());
        addExample(example2());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_cache_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_cache;
    }

    private Observable example1() {
        cacheObservable = Observable.interval(300, TimeUnit.MILLISECONDS).take(10).cache();
        return cacheObservable;
    }

    private Observable example2() {
        cacheObservable = Observable.interval(300, TimeUnit.MILLISECONDS).take(5).cacheWithInitialCapacity(2);
        return cacheObservable;
    }
}
