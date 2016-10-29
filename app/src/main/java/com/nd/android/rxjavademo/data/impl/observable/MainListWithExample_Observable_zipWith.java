package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.functions.Func2;

/**
 * Observable_zipWith
 * <p>
 * Created by HuangYK on 16/10/27.
 */
public class MainListWithExample_Observable_zipWith extends MainListWithExample_Observable {


    private List<Integer> mIntegers = new ArrayList<Integer>() {
        {
            add(15);
            add(16);
            add(17);
            add(18);
            add(19);
            add(20);
        }
    };

    public MainListWithExample_Observable_zipWith() {
        addExample(example1());
        addExample(example2());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_zipWith_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_zipWith;
    }

    private Observable example1() {
        return Observable.range(1, 10).zipWith(Observable.range(10, 15), new Func2() {
            @Override
            public Object call(Object o, Object o2) {
                return "[" + o + "," + o2 + "]";
            }
        });
    }

    private Observable example2() {
        return Observable.range(1, 10).zipWith(mIntegers, new Func2() {
            @Override
            public Object call(Object o, Object o2) {
                return "[" + o + "," + o2 + "]";
            }
        });
    }
}
