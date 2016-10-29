package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import java.util.concurrent.TimeUnit;

import rx.Observable;

/**
 * Observable_timer
 * <p>
 * Created by HuangYK on 16/10/27.
 */
public class MainListWithExample_Observable_timer extends MainListWithExample_Observable {

    public MainListWithExample_Observable_timer() {
        addExample(example1());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_timer_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_timer;
    }

    private Observable example1() {
        return Observable.timer(1000, TimeUnit.MILLISECONDS);
    }


}
