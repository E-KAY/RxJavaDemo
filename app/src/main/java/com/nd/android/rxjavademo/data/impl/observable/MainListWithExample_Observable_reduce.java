package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import rx.Observable;
import rx.functions.Func2;

/**
 * Observable_reduce
 * <p>
 * Created by HuangYK on 16/10/3.
 */
public class MainListWithExample_Observable_reduce extends MainListWithExample_Observable {

    public MainListWithExample_Observable_reduce() {
        addExample(example1());
        addExample(example2());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_reduce_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_reduce;
    }

    private Observable example1() {
        // reduce(Func2<T, T, T> accumulator)

        // 相当于 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10
        return Observable.range(1, 10).reduce(new Func2<Integer, Integer, Integer>() {
            @Override
            public Integer call(Integer integer, Integer integer2) {
                return integer + integer2;
            }
        });
    }

    private Observable example2() {

        // 相当于 11 + 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10
        return Observable.range(1, 10).reduce(11, new Func2<Integer, Integer, Integer>() {
            @Override
            public Integer call(Integer integer, Integer integer2) {
                return integer + integer2;
            }
        });
    }
}


