package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import rx.Observable;
import rx.functions.Func1;

/**
 * Observable_map
 * <p/>
 * Created by HuangYK on 16/10/3.
 */
public class MainListWithExample_Observable_map extends MainListWithExample_Observable {

    public MainListWithExample_Observable_map() {
        addExample(example1());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_map_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_map;
    }

    private Observable example1() {
        return Observable.just("map")
                .map(new Func1<String, String>() {
                    @Override
                    public String call(String s) {
                        return "Observable." + s;
                    }
                });
    }

}
