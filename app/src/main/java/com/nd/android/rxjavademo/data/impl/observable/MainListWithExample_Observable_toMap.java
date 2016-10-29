package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import java.util.Hashtable;
import java.util.Map;

import rx.Observable;
import rx.functions.Func0;
import rx.functions.Func1;

/**
 * Observable_toMap
 * <p>
 * Created by HuangYK on 16/10/27.
 */
public class MainListWithExample_Observable_toMap extends MainListWithExample_Observable {

    public MainListWithExample_Observable_toMap() {
        addExample(example1());
        addExample(example2());
        addExample(example3());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_toMap_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_toMap;
    }

    private Observable example1() {
        return Observable.range(1, 10).toMap(new Func1<Integer, String>() {
            @Override
            public String call(Integer integer) {
                return "key" + integer;
            }
        });
    }

    private Observable example2() {
        return Observable.range(1, 10).toMap(new Func1<Integer, String>() {
            @Override
            public String call(Integer integer) {
                return "key" + integer;
            }
        }, new Func1<Integer, String>() {
            @Override
            public String call(Integer integer) {
                return "value" + integer;
            }
        });
    }

    private Observable example3() {
        return Observable.range(1, 10).toMap(new Func1<Integer, String>() {
            @Override
            public String call(Integer integer) {
                return "key" + integer;
            }
        }, new Func1<Integer, String>() {
            @Override
            public String call(Integer integer) {
                return "value" + integer;
            }
        }, new Func0<Map<String, String>>() {
            @Override
            public Map<String, String> call() {
                return new Hashtable<>();
            }
        });
    }

}
