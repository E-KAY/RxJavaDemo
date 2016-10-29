package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;
import com.nd.android.rxjavademo.utils.RxJavaDemoUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.functions.Func1;

/**
 * Observable_using
 * <p>
 * Created by HuangYK on 16/10/27.
 */
public class MainListWithExample_Observable_using extends MainListWithExample_Observable {

    public MainListWithExample_Observable_using() {
        addExample(example1());
        addExample(example2());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_using_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_using;
    }

    private Observable example1() {

        return Observable.using(new Func0<IntervalParams>() {
            @Override
            public IntervalParams call() {
                return new IntervalParams(500, TimeUnit.MILLISECONDS, 10);
            }
        }, new Func1<IntervalParams, Observable<Long>>() {
            @Override
            public Observable<Long> call(IntervalParams params) {
                return params.mIntervalObservable;
            }
        }, new Action1<IntervalParams>() {
            @Override
            public void call(IntervalParams params) {
                RxJavaDemoUtils.LogW(params.mLongList.toString());
            }
        });

    }

    private Observable example2() {
        return Observable.using(new Func0<IntervalParams>() {
            @Override
            public IntervalParams call() {
                return new IntervalParams(500, TimeUnit.MILLISECONDS, 10);
            }
        }, new Func1<IntervalParams, Observable<Long>>() {
            @Override
            public Observable<Long> call(IntervalParams params) {
                return params.mIntervalObservable;
            }
        }, new Action1<IntervalParams>() {
            @Override
            public void call(IntervalParams params) {
                RxJavaDemoUtils.LogW(params.mLongList.toString());
            }
        }, true);
    }

    private class IntervalParams {
        Observable<Long> mIntervalObservable;
        List<Long> mLongList = new ArrayList<>();

        IntervalParams(long interval, TimeUnit timeUnit, int takeCount) {
            mIntervalObservable = Observable.interval(interval, timeUnit).take(takeCount).map(new Func1<Long, Long>() {
                @Override
                public Long call(Long aLong) {
                    mLongList.add(aLong);
                    return aLong;
                }
            });

        }
    }

}
