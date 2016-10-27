package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Func1;

/**
 * Observable_skipWhile
 * <p>
 * Created by HuangYK on 16/10/25.
 */
public class MainListWithExample_Observable_skipWhile extends MainListWithExample_Observable {

    public MainListWithExample_Observable_skipWhile() {
        addExample(example1());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_skipWhile_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_skipWhile;
    }

    private Observable example1() {
        return Observable.interval(100, TimeUnit.MILLISECONDS).take(10)
                .skipWhile(new Func1<Long, Boolean>() {
                    @Override
                    public Boolean call(Long aLong) {
                        return aLong < 4;
                    }
                });
    }


}


