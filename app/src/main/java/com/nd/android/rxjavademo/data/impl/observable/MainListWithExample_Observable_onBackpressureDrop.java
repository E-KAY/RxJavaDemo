package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;
import com.nd.android.rxjavademo.utils.RxJavaDemoUtils;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Observable_onBackpressureDrop
 * <p>
 * Created by HuangYK on 16/10/3.
 */
public class MainListWithExample_Observable_onBackpressureDrop extends MainListWithExample_Observable {

    public MainListWithExample_Observable_onBackpressureDrop() {
        addExample(example1());
        addExample(example2());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_onBackpressureDrop_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_onBackpressureDrop;
    }

    private Observable example1() {
        // onBackpressureDrop，如果消费者无法处理数据，则把数据丢弃

        return Observable.interval(1, TimeUnit.MILLISECONDS)
                .take(100)
                .onBackpressureDrop()
                .observeOn(Schedulers.newThread())
                .map(new Func1<Long, Long>() {
                    @Override
                    public Long call(Long aLong) {
                        try {
                            Thread.sleep(300);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        return aLong;
                    }
                });

    }

    private Observable example2() {
        // onBackpressureDrop(Action1)，被丢弃的数据将会通知 Action1

        return Observable.interval(1, TimeUnit.MILLISECONDS)
                .take(100)
                .onBackpressureDrop(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        RxJavaDemoUtils.LogW("onDrop" + aLong);
                    }
                })
                .observeOn(Schedulers.newThread())
                .map(new Func1<Long, Long>() {
                    @Override
                    public Long call(Long aLong) {
                        try {
                            Thread.sleep(300);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        return aLong;
                    }
                });
    }
}


