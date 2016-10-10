package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import rx.Notification;
import rx.Observable;

/**
 * Observable_dematerialize
 * <p/>
 * Created by HuangYK on 16/10/3.
 */
public class MainListWithExample_Observable_dematerialize extends MainListWithExample_Observable {

    public MainListWithExample_Observable_dematerialize() {
        addExample(example1());
        addExample(example2());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_dematerialize_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_dematerialize;
    }

    protected Observable example1() {
        return dematerializeObserver();
    }

    protected Observable example2() {
        return meterializeObserver();
    }


    private Observable<Notification<Integer>> meterializeObserver() {
        return Observable.just(1, 2, 3).materialize();
    }

    private Observable<Integer> dematerializeObserver() {
        return meterializeObserver().dematerialize();
    }
}
