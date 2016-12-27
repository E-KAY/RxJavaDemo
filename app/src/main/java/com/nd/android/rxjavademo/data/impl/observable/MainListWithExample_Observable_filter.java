package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * Observable_filter
 * <p>
 * Created by HuangYK on 16/10/3.
 */
public class MainListWithExample_Observable_filter extends MainListWithExample_Observable {

    public MainListWithExample_Observable_filter() {
        addExample(example1());
        addExample(example2());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_filter_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_filter;
    }


    private Observable example1() {
        return Observable.interval(300, TimeUnit.MILLISECONDS).take(10).filter(new Func1<Long, Boolean>() {
            @Override
            public Boolean call(Long aLong) {
                return aLong > 5;
            }
        });
    }

    private Observable example2() {
        List<Observable<Long>> observables = new ArrayList<>();
        observables.add(Observable.create(new Observable.OnSubscribe<Long>() {
            @Override
            public void call(Subscriber<? super Long> subscriber) {
                long count = 0;
                while (count < 10) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    subscriber.onNext(count++);
                }
                subscriber.onCompleted();

            }
        }));
        observables.add(Observable.create(new Observable.OnSubscribe<Long>() {
            @Override
            public void call(Subscriber<? super Long> subscriber) {
                long count = 0;
                while (count < 10) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    subscriber.onNext(count++);
                }
                subscriber.onCompleted();

            }
        }));
        observables.add(Observable.create(new Observable.OnSubscribe<Long>() {
            @Override
            public void call(Subscriber<? super Long> subscriber) {
                long count = 0;
                while (count < 10) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    subscriber.onNext(count++);
                }
                subscriber.onCompleted();

            }
        }));

        return Observable.concat(Observable.from(observables)).filter(new Func1<Long, Boolean>() {
            @Override
            public Boolean call(Long aLong) {
                return aLong >= 9;
            }
        });
    }

}
