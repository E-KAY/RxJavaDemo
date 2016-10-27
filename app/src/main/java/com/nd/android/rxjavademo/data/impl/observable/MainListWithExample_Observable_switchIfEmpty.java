package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import rx.Observable;

/**
 * Observable_switchIfEmpty
 * <p>
 * Created by HuangYK on 16/10/25.
 */
public class MainListWithExample_Observable_switchIfEmpty extends MainListWithExample_Observable {

    public MainListWithExample_Observable_switchIfEmpty() {
        addExample(example1());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_switchIfEmpty_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_switchIfEmpty;
    }

    private Observable example1() {
        return Observable.empty().switchIfEmpty(Observable.range(1, 5));
    }


}
