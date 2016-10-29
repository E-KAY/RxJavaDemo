package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.observables.BlockingObservable;

/**
 * Observable_toBlocking
 * <p>
 * Created by HuangYK on 16/10/27.
 */
public class MainListWithExample_Observable_toBlocking extends MainListWithExample_Observable {

    public MainListWithExample_Observable_toBlocking() {
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_toBlocking_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_toBlocking;
    }

    private BlockingObservable example1() {
        return Observable.interval(300, TimeUnit.MILLISECONDS).toBlocking();
    }

}
