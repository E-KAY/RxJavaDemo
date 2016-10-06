package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Func1;

/**
 * Observable_limit
 * <p/>
 * Created by HuangYK on 16/10/3.
 */
public class MainListWithExample_Observable_limit extends MainListWithExample_Observable {

    public MainListWithExample_Observable_limit() {
        addExample(example1());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_lastOrDefault_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_limit;
    }

    private Observable example1() {
        return Observable.interval(300, TimeUnit.MILLISECONDS).limit(10);
    }

}
