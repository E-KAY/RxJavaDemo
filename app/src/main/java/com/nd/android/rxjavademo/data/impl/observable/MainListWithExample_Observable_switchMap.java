package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;
import com.nd.android.rxjavademo.utils.RxJavaDemoUtils;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Func1;

/**
 * Observable_switchMap
 * <p>
 * Created by HuangYK on 16/10/25.
 */
public class MainListWithExample_Observable_switchMap extends MainListWithExample_Observable {

    public MainListWithExample_Observable_switchMap() {
        addExample(example1());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_switchMap_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_switchMap;
    }

    private Observable example1() {

        return Observable.interval(200, TimeUnit.MILLISECONDS).take(10).switchMap(new Func1<Long, Observable<Long>>() {
            @Override
            public Observable<Long> call(Long aLong) {
                RxJavaDemoUtils.LogW("" + aLong);
                return Observable.just(aLong).delay(aLong * 50, TimeUnit.MILLISECONDS);
            }
        });
    }


}
