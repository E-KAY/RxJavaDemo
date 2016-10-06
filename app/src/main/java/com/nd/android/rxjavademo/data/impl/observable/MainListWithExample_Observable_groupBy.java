package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import rx.Observable;
import rx.functions.Func1;

/**
 * Observable_groupBy
 * <p/>
 * Created by HuangYK on 16/10/3.
 */
public class MainListWithExample_Observable_groupBy extends MainListWithExample_Observable {

    public MainListWithExample_Observable_groupBy() {
        addExample(example1());
        addExample(example2());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_groupBy_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_groupBy;
    }


    private Observable example1() {
        return Observable.range(0, 10).groupBy(new Func1<Integer, Integer>() {
            @Override
            public Integer call(Integer integer) {
                return integer % 3;////分成0，1，2 三个小组
            }
        });
    }

    private Observable example2() {
        return Observable.range(0, 10).groupBy(new Func1<Integer, Integer>() {
            @Override
            public Integer call(Integer integer) {
                return integer % 2;////分成0，1，2 三个小组
            }
        }, new Func1<Integer, Integer>() {
            @Override
            public Integer call(Integer integer) {
                return integer * 10;
            }
        });
    }
}
