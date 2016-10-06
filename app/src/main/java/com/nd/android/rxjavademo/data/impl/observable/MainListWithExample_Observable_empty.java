package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

/**
 * Observable_empty
 * <p>
 * Created by HuangYK on 16/10/3.
 */
public class MainListWithExample_Observable_empty extends MainListWithExample_Observable {

    public MainListWithExample_Observable_empty() {
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_empty_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_empty;
    }

}
