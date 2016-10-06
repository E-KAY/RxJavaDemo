package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import java.util.ArrayList;

import rx.Observable;
import rx.functions.Func1;

/**
 * Observable_flatMapIterable
 * <p/>
 * Created by HuangYK on 16/10/3.
 */
public class MainListWithExample_Observable_flatMapIterable extends MainListWithExample_Observable {

    public MainListWithExample_Observable_flatMapIterable() {
        addExample(example1());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_flatMapIterable_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_flatMapIterable;
    }


    private Observable example1() {
        return Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .flatMapIterable(new Func1<Integer, Iterable<Integer>>() {
                    @Override
                    public Iterable<Integer> call(Integer integer) {
                        ArrayList<Integer> s = new ArrayList<>();
                        for (int i = 0; i < integer; i++) {
                            s.add(i);
                        }
                        return s;
                    }
                });
    }
}
