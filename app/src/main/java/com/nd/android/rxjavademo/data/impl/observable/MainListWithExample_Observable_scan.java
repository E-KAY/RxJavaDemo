package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import rx.Observable;
import rx.functions.Func2;

/**
 * Observable_scan
 * <p>
 * Created by HuangYK on 16/10/24.
 */
public class MainListWithExample_Observable_scan extends MainListWithExample_Observable {

    public MainListWithExample_Observable_scan() {
        addExample(example1());
        addExample(example2());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_scan_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_scan;
    }

    private Observable example1() {
        return Observable.range(1, 5).scan(new Func2<Integer, Integer, Integer>() {
            @Override
            public Integer call(Integer integer, Integer integer2) {
                return integer + integer2;
            }
        });
    }

    private Observable example2() {
        return Observable.range(1, 5).scan(100, new Func2<Integer, Integer, Integer>() {
            @Override
            public Integer call(Integer integer, Integer integer2) {
                return integer + integer2;
            }
        });
    }
}


