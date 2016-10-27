package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import java.util.concurrent.TimeUnit;

import rx.Observable;

/**
 * Observable_skipUntil
 * <p>
 * Created by HuangYK on 16/10/25.
 */
public class MainListWithExample_Observable_skipUntil extends MainListWithExample_Observable {

    public MainListWithExample_Observable_skipUntil() {
        addExample(example1());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_skipUntil_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_skipUntil;
    }

    private Observable example1() {
        return Observable.interval(100, TimeUnit.MILLISECONDS).take(10).skipUntil(Observable.timer(500, TimeUnit.MILLISECONDS));
    }


}


