package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Func1;

/**
 * Observable_replay
 * <p>
 * Created by HuangYK on 16/10/24.
 */
public class MainListWithExample_Observable_replay extends MainListWithExample_Observable {

    private Observable mObservable;

    public MainListWithExample_Observable_replay() {
        addExample(example1());
        addExample(example2());
        addExample(example3());
        addExample(example4());
        addExample(example5());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_replay_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_replay;
    }

    private Observable example1() {
        mObservable = Observable.interval(300, TimeUnit.MILLISECONDS).take(10).replay().autoConnect();
        return mObservable;
    }

    private Observable example2() {
        mObservable = Observable.interval(300, TimeUnit.MILLISECONDS).take(10).replay(3).autoConnect();
        return mObservable;
    }

    private Observable example3() {
        mObservable = Observable.interval(300, TimeUnit.MILLISECONDS).take(10).replay(500, TimeUnit.MILLISECONDS).autoConnect();
        return mObservable;
    }

    private Observable example4() {
        mObservable = Observable.interval(300, TimeUnit.MILLISECONDS).take(10).replay(new Func1<Observable<Long>, Observable<String>>() {
            @Override
            public Observable<String> call(Observable<Long> longObservable) {
                // 这里可以对 Observable 做一些处理

                return longObservable.map(new Func1<Long, String>() {
                    @Override
                    public String call(Long aLong) {
                        return "example7 replay : " + aLong;
                    }
                }).delay(1, TimeUnit.SECONDS);
            }
        });
        return mObservable;
    }

    private Observable example5() {
        mObservable = Observable.interval(200, TimeUnit.MILLISECONDS).take(10).replay(new Func1<Observable<Long>, Observable<Long>>() {
            @Override
            public Observable<Long> call(Observable<Long> observable) {
                return observable.delay(1, TimeUnit.SECONDS);
            }
        }, 2);
        return mObservable;
    }


}


