package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import rx.Observable;
import rx.functions.Func1;

/**
 * Observable_takeWhile
 * <p>
 * Created by HuangYK on 16/10/27.
 */
public class MainListWithExample_Observable_takeWhile extends MainListWithExample_Observable {

    public MainListWithExample_Observable_takeWhile() {
        addExample(example1());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_takeWhile_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_takeWhile;
    }

    private Observable example1() {
        return Observable.just(1, 2, 3, 4, 5, 6, 10, 11, 12, 13).takeWhile(new Func1<Integer, Boolean>() {
            @Override
            public Boolean call(Integer integer) {
                return integer < 6;
            }
        });
    }


}
