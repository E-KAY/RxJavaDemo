package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.functions.Func2;

/**
 * Observable_sequenceEqual
 * <p/>
 * Created by HuangYK on 16/10/25.
 */
public class MainListWithExample_Observable_sequenceEqual extends MainListWithExample_Observable {

    public MainListWithExample_Observable_sequenceEqual() {
        addExample(example1());
        addExample(example2());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_sequenceEqual_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_sequenceEqual;
    }

    private Observable example1() {
        return Observable.sequenceEqual(Observable.from(getExampleList()), Observable.range(1, 5));
    }

    private Observable example2() {
        return Observable.sequenceEqual(
                Observable.from(getExampleList()),
                Observable.range(1, 5),
                new Func2<Integer, Integer, Boolean>() {
                    @Override
                    public Boolean call(Integer integer, Integer integer2) {
                        return integer.equals(integer2);
                    }
                });
    }


    private List<Integer> getExampleList() {
        return new ArrayList<Integer>() {
            {
                add(1);
                add(2);
                add(3);
                add(4);
                add(5);
            }
        };
    }
}


