package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import java.util.concurrent.Callable;

import rx.Observable;

/**
 * Observable_fromCallable
 * <p/>
 * Created by HuangYK on 16/10/3.
 */
public class MainListWithExample_Observable_fromCallable extends MainListWithExample_Observable {

    public MainListWithExample_Observable_fromCallable() {
        addExample(example1());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_fromCallable_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_fromCallable;
    }

    private Observable example1() {
        return Observable.fromCallable(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "fromCallable";
            }
        });
    }
}
