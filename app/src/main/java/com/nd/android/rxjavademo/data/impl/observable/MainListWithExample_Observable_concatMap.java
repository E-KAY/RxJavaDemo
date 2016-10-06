package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * Observable_concatMap
 * <p/>
 * Created by HuangYK on 16/10/3.
 */
public class MainListWithExample_Observable_concatMap extends MainListWithExample_Observable {


    public MainListWithExample_Observable_concatMap() {
        addExample(example1());
        addExample(example2());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_concatMap_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_concatMap;
    }

    private Observable example1() {
        return Observable.from(new ArrayList<Integer>() {
            {
                add(3);
                add(2);
                add(1);
            }
        }).concatMap(new Func1<Integer, Observable<Integer>>() {
            @Override
            public Observable<Integer> call(Integer integer) {
                return getConcatMapObservable(integer);
            }
        });
    }


    private Observable example2() {
        return Observable.from(new ArrayList<Integer>() {
            {
                add(3);
                add(2);
                add(1);
            }
        }).concatMapIterable(new Func1<Integer, Iterable<Integer>>() {
            @Override
            public Iterable<Integer> call(final Integer integer) {
                List<Integer> integers = new ArrayList<>();
                integers.add(integer * 10);
                integers.add(integer * 100);
                integers.add(integer * 1000);
                return integers;
            }
        });
    }

    private Observable<Integer> getConcatMapObservable(final Integer integer) {
        return Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                int result = integer * 100;
                try {
                    Thread.sleep(result);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                subscriber.onNext(result);
                subscriber.onCompleted();
            }
        });
    }
}
