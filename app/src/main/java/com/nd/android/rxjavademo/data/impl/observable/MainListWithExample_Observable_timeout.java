package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Func0;
import rx.functions.Func1;

/**
 * Observable_timeout
 * <p>
 * Created by HuangYK on 16/10/27.
 */
public class MainListWithExample_Observable_timeout extends MainListWithExample_Observable {

    public MainListWithExample_Observable_timeout() {
        addExample(example1());
        addExample(example2());
        addExample(example3());
        addExample(example4());
        addExample(example5());
        addExample(example6());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_timeout_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_timeout;
    }

    private Observable example1() {
        return Observable
                .interval(1000, TimeUnit.MILLISECONDS)
                .timeout(500, TimeUnit.MILLISECONDS);
    }

    private Observable example2() {
        return Observable
                .interval(1000, TimeUnit.MILLISECONDS)
                .timeout(500, TimeUnit.MILLISECONDS, Observable.just(408L));
    }

    private Observable example3() {
        return Observable
                .interval(0, 300, TimeUnit.MILLISECONDS)
                .take(5)
                .timeout(
                        new Func1<Long, Observable<String>>() {
                            @Override
                            public Observable<String> call(Long aLong) {
                                if (aLong == 3) {
                                    return Observable.just("");
                                }
                                return Observable.just("").delay(500, TimeUnit.MILLISECONDS);
                            }
                        });
    }

    private Observable example4() {
        return Observable
                .interval(0, 300, TimeUnit.MILLISECONDS)
                .take(5)
                .timeout(
                        new Func1<Long, Observable<String>>() {
                            @Override
                            public Observable<String> call(Long aLong) {
                                if (aLong == 3) {
                                    return Observable.just("");
                                }
                                return Observable.just("").delay(500, TimeUnit.MILLISECONDS);
                            }
                        }, Observable.just(408L));
    }

    private Observable example5() {
        return Observable
                .interval(10, 300, TimeUnit.MILLISECONDS)
                .take(5)
                .timeout(
                        new Func0<Observable<Long>>() {
                            @Override
                            public Observable<Long> call() {
                                return Observable.timer(100, TimeUnit.MILLISECONDS);
                            }
                        }, new Func1<Long, Observable<String>>() {
                            @Override
                            public Observable<String> call(Long aLong) {
                                if (aLong == 3) {
                                    return Observable.just("");
                                }
                                return Observable.just("").delay(500, TimeUnit.MILLISECONDS);
                            }
                        });
    }

    private Observable example6() {
        return Observable
                .interval(10, 300, TimeUnit.MILLISECONDS)
                .take(5)
                .timeout(
                        new Func0<Observable<Long>>() {
                            @Override
                            public Observable<Long> call() {
                                return Observable.timer(100, TimeUnit.MILLISECONDS);
                            }
                        }, new Func1<Long, Observable<String>>() {
                            @Override
                            public Observable<String> call(Long aLong) {
                                if (aLong == 3) {
                                    return Observable.just("");
                                }
                                return Observable.just("").delay(500, TimeUnit.MILLISECONDS);
                            }
                        }, Observable.just(408L));
    }


}
