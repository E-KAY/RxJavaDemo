package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import rx.Observable;
import rx.functions.Func1;

/**
 * Observable_lastOrDefault
 * <p/>
 * Created by HuangYK on 16/10/3.
 */
public class MainListWithExample_Observable_lastOrDefault extends MainListWithExample_Observable {

    public MainListWithExample_Observable_lastOrDefault() {
        addExample(example1());
        addExample(example2());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_lastOrDefault_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_lastOrDefault;
    }

    private Observable example1() {
        return Observable.empty().lastOrDefault(10);
    }

    private Observable example2() {
        return Observable.range(1, 20).lastOrDefault(100, new Func1<Integer, Boolean>() {
            @Override
            public Boolean call(Integer integer) {
                return integer > 20;
            }
        });
    }
}
