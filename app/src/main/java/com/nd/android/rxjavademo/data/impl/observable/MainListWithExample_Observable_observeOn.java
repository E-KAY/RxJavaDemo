package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;
import com.nd.android.rxjavademo.utils.RxJavaDemoUtils;

import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Observable_observeOn
 * <p/>
 * Created by HuangYK on 16/10/3.
 */
public class MainListWithExample_Observable_observeOn extends MainListWithExample_Observable {

    public MainListWithExample_Observable_observeOn() {
        addExample(example1());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_observeOn_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_observeOn;
    }

    private Observable example1() {
        return Observable.just("RxJava")
                .observeOn(Schedulers.newThread())
                .map(new Func1<String, String>() {
                    @Override
                    public String call(String string) {
                        RxJavaDemoUtils.threadInfo(".map()-1");
                        return string + "-map()-1";
                    }
                }).map(new Func1<String, String>() {
                    @Override
                    public String call(String string) {
                        RxJavaDemoUtils.threadInfo(".map()-2");
                        return string + "-map()-2";
                    }
                });
    }
}


