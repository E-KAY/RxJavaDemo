package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import rx.Observable;
import rx.functions.Func1;

/**
 * Observable_firstOrDefault
 * <p>
 * Created by HuangYK on 16/10/3.
 */
public class MainListWithExample_Observable_firstOrDefault extends MainListWithExample_Observable {

    public MainListWithExample_Observable_firstOrDefault() {
        addExample(example1());
        addExample(example2());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_firstOrDefault_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_firstOrDefault;
    }


    private Observable example1() {
        return Observable.empty().firstOrDefault("example1 firstOrDefault");
    }

    private Observable example2() {
        return Observable.just(0, 1, 2, 3, 4, 5).firstOrDefault(10, new Func1<Integer, Boolean>() {
            @Override
            public Boolean call(Integer integer) {
                return integer > 6;
            }
        });
    }

}
