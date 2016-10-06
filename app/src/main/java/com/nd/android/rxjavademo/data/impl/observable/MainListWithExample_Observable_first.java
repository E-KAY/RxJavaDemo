package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import rx.Observable;
import rx.functions.Func1;

/**
 * Observable_first
 * <p>
 * Created by HuangYK on 16/10/3.
 */
public class MainListWithExample_Observable_first extends MainListWithExample_Observable {

    public MainListWithExample_Observable_first() {
        addExample(example1());
        addExample(example2());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_first_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_first;
    }


    private Observable example1() {
        return Observable.just(0, 1, 2, 3, 4, 5).first(new Func1<Integer, Boolean>() {
            @Override
            public Boolean call(Integer integer) {
                return integer > 3;
            }
        });
    }

    private Observable example2() {
        return Observable.just(0, 1, 2, 3, 4, 5).first(new Func1<Integer, Boolean>() {
            @Override
            public Boolean call(Integer integer) {
                return integer > 6;
            }
        });
    }

}
