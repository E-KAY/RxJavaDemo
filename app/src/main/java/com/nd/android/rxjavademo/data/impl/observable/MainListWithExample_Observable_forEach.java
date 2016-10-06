package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Action0;
import rx.functions.Action1;

/**
 * Observable_forEach
 * <p/>
 * Created by HuangYK on 16/10/3.
 */
public class MainListWithExample_Observable_forEach extends MainListWithExample_Observable {

    public MainListWithExample_Observable_forEach() {

    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_forEach_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_forEach;
    }


    private void example1() {
        Observable.interval(100, TimeUnit.MILLISECONDS).take(5)
                .forEach(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        // 接收 onNext 发出的数据
                    }
                });
    }

    private void example2() {
        Observable.interval(100, TimeUnit.MILLISECONDS).take(5)
                .forEach(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        // 接收 onNext 发出的数据
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        // 接收 onError 发出的数据
                    }
                });
    }

    private void example3() {
        Observable.interval(100, TimeUnit.MILLISECONDS).take(5)
                .forEach(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        // 接收 onNext 发出的数据
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        // 接收 onError 发出的数据
                    }
                }, new Action0() {
                    @Override
                    public void call() {
                        // 接收 onCompleted 发出的数据
                    }
                });
    }
}
