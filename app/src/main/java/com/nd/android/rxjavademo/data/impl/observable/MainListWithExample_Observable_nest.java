package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import java.util.concurrent.TimeUnit;

import rx.Observable;

/**
 * Observable_nest
 * <p/>
 * Created by HuangYK on 16/10/3.
 */
public class MainListWithExample_Observable_nest extends MainListWithExample_Observable {

    public MainListWithExample_Observable_nest() {
        addExample(example1());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_nest_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_nest;
    }

    private Observable example1() {
        // 会先调用一次onCompleted... 好奇葩
        return getObservable();
    }

    private Observable<Observable<Long>> getObservable() {
        return Observable.interval(300, 500, TimeUnit.MILLISECONDS).take(5).nest();
    }


}
