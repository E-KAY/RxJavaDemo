package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Observable_onBackpressureLatest
 * <p>
 * Created by HuangYK on 16/10/3.
 */
public class MainListWithExample_Observable_onBackpressureLatest extends MainListWithExample_Observable {

    public MainListWithExample_Observable_onBackpressureLatest() {
        addExample(example1());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_onBackpressureLatest_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_onBackpressureLatest;
    }

    private Observable example1() {
        // onBackpressureLatest，如果消费者无法处理数据，则把数据丢弃，保留最后一个

        return Observable.interval(1, TimeUnit.MILLISECONDS)
                .take(100)
                .onBackpressureLatest()
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


