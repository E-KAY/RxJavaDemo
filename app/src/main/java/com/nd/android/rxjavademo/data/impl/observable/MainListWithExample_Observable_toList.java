package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import rx.Observable;

/**
 * Observable_toList
 * <p>
 * Created by HuangYK on 16/10/27.
 */
public class MainListWithExample_Observable_toList extends MainListWithExample_Observable {

    public MainListWithExample_Observable_toList() {
        addExample(example1());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_toList_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_toList;
    }

    private Observable example1() {
        return Observable.range(1, 5).toList();
    }

}
