package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

/**
 * Observable_materialize
 * <p/>
 * Created by HuangYK on 16/10/3.
 */
public class MainListWithExample_Observable_materialize extends MainListWithExample_Observable_dematerialize {

    public MainListWithExample_Observable_materialize() {
        addExample(example1());
        addExample(example2());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_materialize_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_materialize;
    }
}
