package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.functions.FuncN;
import rx.schedulers.Schedulers;

/**
 * Observable_combineLatest
 * <p/>
 * Created by HuangYK on 16/10/3.
 */
public class MainListWithExample_Observable_combineLatest extends MainListWithExample_Observable {


    public MainListWithExample_Observable_combineLatest() {
        addExample(example1());
        addExample(example2());
        addExample(example3());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_combineLatest_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_combineLatest;
    }

    private Observable example1() {
        Observable<String> observable1 = Observable.interval(500, TimeUnit.MILLISECONDS)
                .map(new Func1<Long, String>() {
                    @Override
                    public String call(Long position) {
                        return "observable1 " + position * 10;
                    }
                }).take(10);
        Observable<String> observable2 = Observable.interval(1, TimeUnit.SECONDS)
                .map(new Func1<Long, String>() {
                    @Override
                    public String call(Long position) {
                        return "observable2 " + position * 10;
                    }
                }).take(10);

        // 这种写法最多可以放9个Observable
        return Observable.combineLatest(observable1, observable2, new Func2<String, String, List<String>>() {
            @Override
            public List<String> call(final String s, final String s2) {
                return new ArrayList<String>() {
                    {
                        add(s == null ? "" : s);
                        add(s2 == null ? "" : s2);
                    }
                };
            }
        });
    }

    private Observable example2() {
        Observable<String> observable1 = Observable.interval(500, TimeUnit.MILLISECONDS)
                .map(new Func1<Long, String>() {
                    @Override
                    public String call(Long position) {
                        return "observable1 " + position * 10;
                    }
                }).take(10);
        Observable<String> observable2 = Observable.interval(1, TimeUnit.SECONDS)
                .map(new Func1<Long, String>() {
                    @Override
                    public String call(Long position) {
                        return "observable2 " + position * 10;
                    }
                }).take(10);
        List<Observable<String>> observableList = new ArrayList<>();
        observableList.add(observable1);
        observableList.add(observable2);

        return Observable.combineLatest(observableList, new FuncN<Object>() {
            @Override
            public Object call(Object... args) {
                List<String> results = new ArrayList<>();
                for (Object object : args) {
                    if (object == null) {
                        continue;
                    }
                    results.add((String) object);
                }
                return results;
            }
        });
    }

    private Observable example3() {
        Observable<String> observable1 = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(final Subscriber<? super String> subscriber) {
                final Scheduler.Worker worker = Schedulers.io().createWorker();
                subscriber.add(worker);
                worker.schedulePeriodically(new Action0() {
                    long counter = 0;

                    @Override
                    public void call() {
                        if (counter == 8) {
                            subscriber.onError(new Throwable());
                        }
                        try {
                            subscriber.onNext("Observable1 " + counter++ * 10);
                        } catch (Throwable e) {
                            try {
                                worker.unsubscribe();
                            } finally {
                                Exceptions.throwOrReport(e, subscriber);
                            }
                        }
                    }
                }, 1000, 1000, TimeUnit.MILLISECONDS);
            }
        });
        Observable<String> observable2 = Observable.interval(1, TimeUnit.SECONDS)
                .map(new Func1<Long, String>() {
                    @Override
                    public String call(Long position) {
                        return "observable2 " + position * 10;
                    }
                }).take(10);
        List<Observable<String>> observableList = new ArrayList<>();
        observableList.add(observable1);
        observableList.add(observable2);

        return Observable.combineLatestDelayError(observableList, new FuncN<Object>() {
            @Override
            public Object call(Object... args) {
                List<String> results = new ArrayList<>();
                for (Object object : args) {
                    results.add((String) object);
                }
                return results;
            }
        });
    }
}
