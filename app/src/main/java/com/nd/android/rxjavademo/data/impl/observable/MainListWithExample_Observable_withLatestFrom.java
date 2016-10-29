package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.functions.Func3;
import rx.functions.FuncN;

/**
 * Observable_withLatestFrom
 * <p>
 * Created by HuangYK on 16/10/27.
 */
public class MainListWithExample_Observable_withLatestFrom extends MainListWithExample_Observable {

    public MainListWithExample_Observable_withLatestFrom() {
        addExample(example1());
        addExample(example2());
        addExample(example3());
        addExample(example4());

    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_withLatestFrom_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_withLatestFrom;
    }

    private Observable example1() {
        return Observable.interval(500, TimeUnit.MILLISECONDS).take(10)
                .withLatestFrom(Observable.interval(200, TimeUnit.MILLISECONDS).take(5), new Func2<Long, Long, String>() {
                    @Override
                    public String call(Long aLong1, Long aLong2) {
                        return aLong1 + "+" + aLong2 + "=" + (aLong1 + aLong2);
                    }
                });
    }

    private Observable example2() {
        return Observable.interval(500, TimeUnit.MILLISECONDS).take(10)
                .withLatestFrom(
                        Observable.interval(300, TimeUnit.MILLISECONDS).take(5),
                        Observable.just("One", "Two", "Three", "Four"),
                        new Func3<Long, Long, String, String>() {
                            @Override
                            public String call(Long aLong1, Long aLong2, String string) {
                                return "result : along1 = " + aLong1 + ", aLong2 = " + aLong2 + ", string = " + string;
                            }
                        });
    }

    private Observable example3() {
        return Observable.interval(500, TimeUnit.MILLISECONDS).take(10)
                .withLatestFrom(
                        mObservableList,
                        new FuncN<String>() {
                            @Override
                            public String call(Object... args) {
                                String s = "[";
                                for (Object object : args) {
                                    s += object + ",";
                                }
                                s += "]";
                                return s;
                            }
                        });
    }

    private Observable example4() {
        return Observable.interval(500, TimeUnit.MILLISECONDS).take(10)
                .withLatestFrom(
                        mObservables,
                        new FuncN<String>() {
                            @Override
                            public String call(Object... args) {
                                String s = "[";
                                for (Object object : args) {
                                    s += object + ",";
                                }
                                s += "]";
                                return s;
                            }
                        });
    }


    private List<Observable<?>> mObservableList = new ArrayList<Observable<?>>() {
        {
            add(Observable.interval(100, TimeUnit.MILLISECONDS).take(10).map(new Func1<Long, String>() {
                @Override
                public String call(Long aLong) {
                    return "item1 - " + aLong;
                }
            }));
            add(Observable.interval(200, TimeUnit.MILLISECONDS).take(10).map(new Func1<Long, String>() {
                @Override
                public String call(Long aLong) {
                    return "item2 - " + aLong;
                }
            }));
            add(Observable.interval(300, TimeUnit.MILLISECONDS).take(10).map(new Func1<Long, String>() {
                @Override
                public String call(Long aLong) {
                    return "item3 - " + aLong;
                }
            }));
        }
    };

    private Observable<?>[] mObservables = new Observable<?>[]{

            Observable.interval(100, TimeUnit.MILLISECONDS).take(10).map(new Func1<Long, String>() {
                @Override
                public String call(Long aLong) {
                    return "item1 - " + aLong;
                }
            }),
            Observable.interval(200, TimeUnit.MILLISECONDS).take(10).map(new Func1<Long, String>() {
                @Override
                public String call(Long aLong) {
                    return "item2 - " + aLong;
                }
            }),
            Observable.interval(300, TimeUnit.MILLISECONDS).take(10).map(new Func1<Long, String>() {
                @Override
                public String call(Long aLong) {
                    return "item3 - " + aLong;
                }
            }),
    };


}
