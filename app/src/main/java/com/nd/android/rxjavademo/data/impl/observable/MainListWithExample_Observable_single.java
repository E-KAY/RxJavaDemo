package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import rx.Observable;
import rx.functions.Func1;

/**
 * Observable_single
 * <p>
 * Created by HuangYK on 16/10/25.
 */
public class MainListWithExample_Observable_single extends MainListWithExample_Observable {

    public MainListWithExample_Observable_single() {
        addExample(example1());
        addExample(example2());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_single_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_single;
    }

    private Observable example1() {

        // 这样处理将会抛出异常
        return Observable.range(1, 5).single();
    }

    private Observable example2() {

        return Observable.range(1, 5).single(new Func1<Integer, Boolean>() {
            @Override
            public Boolean call(Integer integer) {
                return integer == 3;
            }
        });
    }

}


