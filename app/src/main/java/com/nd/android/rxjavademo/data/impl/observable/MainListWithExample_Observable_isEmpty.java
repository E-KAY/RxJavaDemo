package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import rx.Observable;

/**
 * Observable_isEmpty
 * <p/>
 * Created by HuangYK on 16/10/3.
 */
public class MainListWithExample_Observable_isEmpty extends MainListWithExample_Observable {

    public MainListWithExample_Observable_isEmpty() {
        addExample(example1());
        addExample(example2());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_isEmpty_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_isEmpty;
    }


    private Observable example1() {
        return Observable.empty().isEmpty();
    }

    private Observable example2() {
        return Observable.just(1, 2).isEmpty();
    }
}
