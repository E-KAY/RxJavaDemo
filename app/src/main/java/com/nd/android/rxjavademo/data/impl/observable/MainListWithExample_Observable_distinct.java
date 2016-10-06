package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import rx.Observable;
import rx.functions.Func1;

/**
 * Observable_distinct
 * <p/>
 * Created by HuangYK on 16/10/3.
 */
public class MainListWithExample_Observable_distinct extends MainListWithExample_Observable {

    public MainListWithExample_Observable_distinct() {
        addExample(example1());
        addExample(example2());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_distinct_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_distinct;
    }

    private Observable example1() {
        // Observable<T> distinct()

        return Observable.just(1, 2, 3, 4, 5, 2, 5, 12, 45).distinct();
    }

    private Observable example2() {
        // <U> Observable<T> distinct(Func1<? super T, ? extends U> keySelector)

        return Observable.just(1, 2, 3, 4, 5, 2, 5, 12, 45).distinct(new Func1<Integer, Integer>() {
            @Override
            public Integer call(Integer integer) {
                return integer;
            }
        });
    }
}
