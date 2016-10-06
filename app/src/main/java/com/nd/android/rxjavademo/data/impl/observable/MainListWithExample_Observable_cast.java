package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import rx.Observable;

/**
 * Observable_cast
 * <p/>
 * Created by HuangYK on 16/10/3.
 */
public class MainListWithExample_Observable_cast extends MainListWithExample_Observable {


    public MainListWithExample_Observable_cast() {
        addExample(example1());
        addExample(example2());
        addExample(example3());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_cast_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_cast;
    }

    private Observable example1() {
        return Observable.just(1, 2f, 3L, 4d).cast(Number.class);
    }

    private Observable example2() {
        return Observable.just(1, 2, "3", 4, 5).cast(Integer.class);
    }

    private Observable example3() {
        return Observable.just(1, 2, "3", 4).cast(String.class);
    }
}
