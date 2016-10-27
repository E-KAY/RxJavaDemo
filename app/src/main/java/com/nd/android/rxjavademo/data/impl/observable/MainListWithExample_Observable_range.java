package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Observable_range
 * <p>
 * Created by HuangYK on 16/10/3.
 */
public class MainListWithExample_Observable_range extends MainListWithExample_Observable {

    public MainListWithExample_Observable_range() {
        addExample(example1());
        addExample(example2());
        addExample(example3());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_range_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_range;
    }

    private Observable example1() {
        // range(int, int);

        return Observable.range(1, 10);

        // 如果 count 为-1 则会抛异常
//        return Observable.range(10, -1);
    }

    private Observable example2() {
        return Observable.range(10, 0);
    }


    private Observable example3() {
        //  range(int, int, Scheduler)

        return Observable.range(10, 20, AndroidSchedulers.mainThread());
    }
}


