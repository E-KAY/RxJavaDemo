package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import rx.Observable;
import rx.functions.Func2;

/**
 * Observable_toSortedList
 * <p>
 * Created by HuangYK on 16/10/27.
 */
public class MainListWithExample_Observable_toSortedList extends MainListWithExample_Observable {

    public MainListWithExample_Observable_toSortedList() {
        addExample(example1());
        addExample(example2());
        addExample(example3());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_toSortedList_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_toSortedList;
    }

    private Observable example1() {
        return Observable.just(9, 7, 5, 3, 1, 10, 8, 6, 4, 2).toSortedList();
    }

    private Observable example2() {
        return Observable.just(9, 7, 5, 3, 1, 10, 8, 6, 4, 2).toSortedList(new Func2<Integer, Integer, Integer>() {
            @Override
            public Integer call(Integer integer, Integer integer2) {
                return integer - integer2;
            }
        });
    }

    private Observable example3() {
        return Observable.just(9, 7, 5, 3, 1, 10, 8, 6, 4, 2).toSortedList(new Func2<Integer, Integer, Integer>() {
            @Override
            public Integer call(Integer integer, Integer integer2) {
                return integer2 - integer;
            }
        });
    }
}
