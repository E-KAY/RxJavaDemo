package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import java.util.concurrent.TimeUnit;

import rx.Completable;
import rx.Observable;

/**
 * Observable_toCompletable
 * <p>
 * Created by HuangYK on 16/10/27.
 */
public class MainListWithExample_Observable_toCompletable extends MainListWithExample_Observable {

    public MainListWithExample_Observable_toCompletable() {
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_toCompletable_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_toCompletable;
    }

    private Completable example1() {
        return Observable.interval(300, TimeUnit.MILLISECONDS).toCompletable();
    }

}
