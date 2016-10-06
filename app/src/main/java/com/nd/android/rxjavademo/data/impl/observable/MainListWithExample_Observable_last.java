package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import rx.Observable;
import rx.functions.Func1;

/**
 * Observable_last
 * <p/>
 * Created by HuangYK on 16/10/3.
 */
public class MainListWithExample_Observable_last extends MainListWithExample_Observable {

    public MainListWithExample_Observable_last() {
        addExample(example1());
        addExample(example2());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_last_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_last;
    }

    private Observable example1() {
        return Observable.range(1, 10).last();
    }

    private Observable example2() {
        return Observable.range(1, 20).last(new Func1<Integer, Boolean>() {
            @Override
            public Boolean call(Integer integer) {
                return integer > 15;
            }
        });
    }
}
