package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import rx.Observable;

/**
 * Observable_count
 * <p/>
 * Created by HuangYK on 16/10/3.
 */
public class MainListWithExample_Observable_count extends MainListWithExample_Observable {


    public MainListWithExample_Observable_count() {
        addExample(example1());
        addExample(example2());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_count_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_count;
    }

    private Observable example1() {
        return Observable.range(1, 10).count();

        // 如果长度可能达到Long级别，用 countLong，不详细介绍了
    }


    private Observable example2() {
        return Observable.empty().count();
    }
}
