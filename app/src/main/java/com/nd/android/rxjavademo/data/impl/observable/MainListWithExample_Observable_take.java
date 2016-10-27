package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import java.util.concurrent.TimeUnit;

import rx.Observable;

/**
 * Observable_take
 * <p>
 * Created by HuangYK on 16/10/26.
 */
public class MainListWithExample_Observable_take extends MainListWithExample_Observable {

    public MainListWithExample_Observable_take() {
        addExample(example1());
        addExample(example2());
        addExample(example3());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_take_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_take;
    }

    private Observable example1() {
        return Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9).take(5);
    }

    private Observable example2() {
        return Observable.just(1, 2).take(5);
    }

    private Observable example3() {
        return Observable.interval(0, 300, TimeUnit.MILLISECONDS).take(1000, TimeUnit.MILLISECONDS);
    }


}
