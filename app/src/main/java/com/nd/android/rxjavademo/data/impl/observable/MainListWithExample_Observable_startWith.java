package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

/**
 * Observable_startWith
 * <p>
 * Created by HuangYK on 16/10/25.
 */
public class MainListWithExample_Observable_startWith extends MainListWithExample_Observable {

    public MainListWithExample_Observable_startWith() {
        addExample(example1());
        addExample(example2());
        addExample(example3());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_startWith_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_startWith;
    }

    private Observable example1() {
        return Observable.range(10, 15).startWith(1, 2, 3, 4, 5);
    }

    private Observable example2() {
        return Observable.range(10, 15).startWith(Observable.range(1, 5));
    }

    private Observable example3() {
        return Observable.range(10, 15).startWith(getList());
    }


    private List<Integer> getList() {
        return new ArrayList<Integer>() {
            {
                add(1);
                add(2);
                add(3);
            }
        };
    }
}


