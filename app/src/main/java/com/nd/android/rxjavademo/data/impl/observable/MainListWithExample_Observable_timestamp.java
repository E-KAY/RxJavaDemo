package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import java.util.concurrent.TimeUnit;

import rx.Observable;

/**
 * Observable_timestamp
 * <p>
 * Created by HuangYK on 16/10/27.
 */
public class MainListWithExample_Observable_timestamp extends MainListWithExample_Observable {

    public MainListWithExample_Observable_timestamp() {
        addExample(example1());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_timestamp_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_timestamp;
    }

    private Observable example1() {
        return Observable.interval(500, TimeUnit.MILLISECONDS).take(5).timestamp();
    }

}
