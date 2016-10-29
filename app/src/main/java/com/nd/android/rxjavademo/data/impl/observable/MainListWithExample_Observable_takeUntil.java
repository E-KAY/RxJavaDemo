package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Func1;

/**
 * Observable_takeUntil
 * <p>
 * Created by HuangYK on 16/10/27.
 */
public class MainListWithExample_Observable_takeUntil extends MainListWithExample_Observable {

    public MainListWithExample_Observable_takeUntil() {
        addExample(example1());
        addExample(example2());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_takeUntil_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_takeUntil;
    }

    private Observable example1() {
        return Observable.just(1, 2, 3, 4, 5, 6, 10, 11, 12, 13).takeUntil(new Func1<Integer, Boolean>() {
            @Override
            public Boolean call(Integer integer) {
                return integer == 6;
            }
        });
    }

    private Observable example2() {
        return Observable.interval(0, 300, TimeUnit.MILLISECONDS).takeUntil(Observable.timer(1000, TimeUnit.MILLISECONDS));
    }

}
