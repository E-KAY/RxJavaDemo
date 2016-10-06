package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import rx.Observable;
import rx.functions.Func1;

/**
 * Observable_exists
 * <p>
 * Created by HuangYK on 16/10/3.
 */
public class MainListWithExample_Observable_exists extends MainListWithExample_Observable {

    public MainListWithExample_Observable_exists() {
        addExample(example1());
        addExample(example2());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_exists_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_exists;
    }


    private Observable example1() {
        return Observable.range(0, 2).exists(new Func1<Integer, Boolean>() {
            @Override
            public Boolean call(Integer integer) {
                return integer > 2;
            }
        });
    }

    private Observable example2() {
        return Observable.range(0, 4).exists(new Func1<Integer, Boolean>() {
            @Override
            public Boolean call(Integer integer) {
                return integer > 2;
            }
        });
    }


}
