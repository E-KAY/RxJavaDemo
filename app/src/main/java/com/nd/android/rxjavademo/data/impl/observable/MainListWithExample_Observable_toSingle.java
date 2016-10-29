package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import rx.Observable;
import rx.Single;

/**
 * Observable_toSingle
 * <p>
 * Created by HuangYK on 16/10/27.
 */
public class MainListWithExample_Observable_toSingle extends MainListWithExample_Observable {

    public MainListWithExample_Observable_toSingle() {
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_toSingle_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_toSingle;
    }

    private Single example1() {
        return Observable.just(1).toSingle();
    }

}
