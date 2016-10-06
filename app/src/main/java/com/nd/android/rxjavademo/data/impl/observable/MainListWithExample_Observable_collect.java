package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import java.util.ArrayList;

import rx.Observable;
import rx.functions.Action2;
import rx.functions.Func0;

/**
 * Observable_collect
 * <p/>
 * Created by HuangYK on 16/10/3.
 */
public class MainListWithExample_Observable_collect extends MainListWithExample_Observable {


    public MainListWithExample_Observable_collect() {
        addExample(example1());
        addExample(example2());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_collect_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_collect;
    }

    private Observable example1() {
        return Observable.range(1, 10).collect(new Func0<ArrayList<Integer>>() {
            @Override
            public ArrayList<Integer> call() {
                return new ArrayList<>();
            }
        }, new Action2<ArrayList<Integer>, Integer>() {
            @Override
            public void call(ArrayList<Integer> integers, Integer integer) {
                integers.add(integer);
            }
        });
    }

    private Observable example2() {
        return Observable.range(1, 10).collect(new Func0<ArrayList<Integer>>() {
            @Override
            public ArrayList<Integer> call() {
                return new ArrayList<>();
            }
        }, new Action2<ArrayList<Integer>, Integer>() {
            @Override
            public void call(ArrayList<Integer> integers, Integer integer) {
                if (integer % 2 == 0) {
                    integers.add(integer);
                }
            }
        });
    }
}
