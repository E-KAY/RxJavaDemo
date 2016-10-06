package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import rx.Observable;
import rx.functions.Func0;

/**
 * Observable_defer
 * <p/>
 * Created by HuangYK on 16/10/3.
 */
public class MainListWithExample_Observable_defer extends MainListWithExample_Observable {

    private int mTemp;

    public MainListWithExample_Observable_defer() {
        addExample(example1());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_defer_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_defer;
    }

    private Observable example1() {
        mTemp = 10;
        Observable<Integer> observable = Observable.defer(new Func0<Observable<Integer>>() {
            @Override
            public Observable<Integer> call() {
                return Observable.just(mTemp);
            }
        });
        mTemp = 20;
        return observable;
    }


}
