package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.functions.Func2;

/**
 * Observable_sorted
 * <p>
 * Created by HuangYK on 16/10/25.
 */
public class MainListWithExample_Observable_sorted extends MainListWithExample_Observable {

    public MainListWithExample_Observable_sorted() {
        addExample(example1());
        addExample(example2());
        addExample(example3());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_sorted_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_sorted;
    }

    private Observable example1() {
        return Observable.from(getList()).sorted();
    }

    private Observable example2() {
        return Observable.from(getList()).sorted(new Func2<Integer, Integer, Integer>() {
            @Override
            public Integer call(Integer integer, Integer integer2) {
                return integer2 - integer;
            }
        });
    }

    private Observable example3() {
        return Observable.from(getList()).sorted(new Func2<Integer, Integer, Integer>() {
            @Override
            public Integer call(Integer integer, Integer integer2) {
                return integer - integer2;
            }
        });
    }


    private List<Integer> getList() {
        return new ArrayList<Integer>() {
            {
                add(10);
                add(5);
                add(8);
                add(1);
                add(3);
                add(9);
                add(4);
                add(2);
                add(6);
                add(7);
            }
        };
    }
}


