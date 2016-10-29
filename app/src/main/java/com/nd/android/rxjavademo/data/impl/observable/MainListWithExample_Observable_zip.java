package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.functions.FuncN;

/**
 * Observable_zip
 * <p>
 * Created by HuangYK on 16/10/27.
 */
public class MainListWithExample_Observable_zip extends MainListWithExample_Observable {

    private List<Observable<?>> mObservableList = new ArrayList<Observable<?>>() {
        {
            add(Observable.interval(100, TimeUnit.MILLISECONDS).take(5).map(new Func1<Long, String>() {
                @Override
                public String call(Long aLong) {
                    return "item1 - " + aLong;
                }
            }));
            add(Observable.interval(200, TimeUnit.MILLISECONDS).take(8).map(new Func1<Long, String>() {
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
            Observable.interval(200, TimeUnit.MILLISECONDS).take(5).map(new Func1<Long, String>() {
                @Override
                public String call(Long aLong) {
                    return "item2 - " + aLong;
                }
            }),
            Observable.interval(300, TimeUnit.MILLISECONDS).take(8).map(new Func1<Long, String>() {
                @Override
                public String call(Long aLong) {
                    return "item3 - " + aLong;
                }
            }),
    };


    public MainListWithExample_Observable_zip() {
        addExample(example1());
        addExample(example2());
        addExample(example3());
        addExample(example4());

    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_zip_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_zip;
    }

    private Observable example1() {
        return Observable.zip(mObservables, new FuncN<String>() {
            @Override
            public String call(Object... args) {
                return getResult(args);
            }
        });
    }

    private Observable example2() {
        return Observable.zip(mObservableList, new FuncN<String>() {
            @Override
            public String call(Object... args) {
                return getResult(args);
            }
        });
    }

    private Observable example3() {
        return Observable.zip(Observable.just(Observable.range(1, 10), Observable.range(15, 20)), new FuncN<String>() {
            @Override
            public String call(Object... args) {
                return getResult(args);
            }
        });
    }

    private Observable example4() {
        return Observable.zip(Observable.range(1, 5), Observable.range(10, 20),
                new Func2<Integer, Integer, String>() {
                    @Override
                    public String call(Integer integer1, Integer integer2) {
                        return "[" + integer1 + "," + integer2 + "]";
                    }
                });
    }

    private String getResult(Object... args) {
        String s = "[";
        for (Object object : args) {
            s += object + ",";
        }
        s += "]";
        return s;
    }

}
