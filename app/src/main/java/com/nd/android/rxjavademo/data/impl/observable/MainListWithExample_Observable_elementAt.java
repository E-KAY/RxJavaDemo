package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import rx.Observable;

/**
 * Observable_elementAt
 * <p/>
 * Created by HuangYK on 16/10/3.
 */
public class MainListWithExample_Observable_elementAt extends MainListWithExample_Observable {

    public MainListWithExample_Observable_elementAt() {
        addExample(example1());
        addExample(example2());
        addExample(example3());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_elementAt_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_elementAt;
    }

    private Observable example1() {
        return Observable.just(1, 2, 3, 4, 5, 6, 7, 8).elementAt(5);
    }

    private Observable example2() {
        return Observable.just(1, 2, 3, 4, 5, 6, 7, 8).elementAt(10);
    }

    private Observable example3() {

        // Observable<T> elementAtOrDefault(int index, T defaultValue)
        return Observable.just(1, 2, 3, 4, 5, 6, 7, 8).elementAtOrDefault(10, 10);
    }


}
