package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import rx.Observable;
import rx.functions.Func1;

/**
 * Observable_takeFirst
 * <p>
 * Created by HuangYK on 16/10/26.
 */
public class MainListWithExample_Observable_takeFirst extends MainListWithExample_Observable {

    public MainListWithExample_Observable_takeFirst() {
        addExample(example1());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_takeFirst_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_takeFirst;
    }

    private Observable example1() {
        return Observable.just(1, 2, 3, 4, 5, 6, 10, 11, 12, 13).takeFirst(new Func1<Integer, Boolean>() {
            @Override
            public Boolean call(Integer integer) {
                return integer > 6;
            }
        });
    }
}
