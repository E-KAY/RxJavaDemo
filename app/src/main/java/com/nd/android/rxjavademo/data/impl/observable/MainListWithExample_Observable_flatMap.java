package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Func1;
import rx.functions.Func2;

/**
 * Observable_flatMap
 * <p/>
 * Created by HuangYK on 16/10/3.
 */
public class MainListWithExample_Observable_flatMap extends MainListWithExample_Observable {

    public MainListWithExample_Observable_flatMap() {
        addExample(example1());
        addExample(example2());
        addExample(example3());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_flatMap_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_flatMap;
    }


    private Observable<String> example1() {
        // <R> Observable<R> flatMap(Func1<? super T, ? extends Observable<? extends R>> func)
        return Observable.just(1, 2, 3, 4, 5).flatMap(new Func1<Integer, Observable<String>>() {
            @Override
            public Observable<String> call(Integer integer) {
                return Observable.just(String.valueOf(integer));
            }
        });
    }

    private Observable example2() {
        // <R> Observable<R> flatMap(Func1<? super T, ? extends Observable<? extends R>> func, int maxConcurrent)
        return Observable.interval(300, TimeUnit.MILLISECONDS).take(10).flatMap(new Func1<Long, Observable<String>>() {
            @Override
            public Observable<String> call(Long integer) {
                return Observable.just(String.valueOf(integer));
            }
        }, 3);
    }

    private Observable example3() {
        // <R> Observable<R> flatMap(Func1<? super T, ? extends Observable<? extends R>> func, int maxConcurrent)
        return Observable.just(1, 2, 3, 4, 5, 6).flatMap(new Func1<Integer, Observable<String>>() {
            @Override
            public Observable<String> call(Integer integer) {
                return Observable.just(String.valueOf(integer));
            }
        }, new Func2<Integer, String, String>() {
            @Override
            public String call(Integer o, String o2) {
                return o + o2;
            }
        });
    }

}
