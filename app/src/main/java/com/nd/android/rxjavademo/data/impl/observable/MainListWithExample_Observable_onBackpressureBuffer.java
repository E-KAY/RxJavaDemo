package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;
import com.nd.android.rxjavademo.utils.RxJavaDemoUtils;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Observable_onBackpressureBuffer
 * <p>
 * Created by HuangYK on 16/10/3.
 */
public class MainListWithExample_Observable_onBackpressureBuffer extends MainListWithExample_Observable {

    public MainListWithExample_Observable_onBackpressureBuffer() {
        addExample(example1());
        addExample(example2());
        addExample(example3());
        addExample(example4());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_onBackpressureBuffer_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_onBackpressureBuffer;
    }

    private Observable example1() {
        // 没有使用 onBackpressureBuffer 的情况，将会导致异常

        return Observable.interval(30, TimeUnit.MILLISECONDS)
                .take(20)
                .observeOn(Schedulers.newThread())
                .map(new Func1<Long, Long>() {
                    @Override
                    public Long call(Long aLong) {
                        try {
                            Thread.sleep(300);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        return aLong * 10;
                    }
                });

    }

    private Observable example2() {
        // onBackpressureBuffer()，不限制缓冲区大小

        return Observable.interval(1, TimeUnit.MILLISECONDS)
                .take(20)
                .onBackpressureBuffer()
                .observeOn(Schedulers.newThread())
                .map(new Func1<Long, Long>() {
                    @Override
                    public Long call(Long aLong) {
                        try {
                            Thread.sleep(300);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        return aLong * 10;
                    }
                });

    }

    private Observable example3() {
        // onBackpressureBuffer(long)，可自定义缓冲区大小。
        // 需要注意的是，如果缓冲区大小设置太小而导致缓冲区溢出的话将会触发 onError

        return Observable.interval(30, TimeUnit.MILLISECONDS)
                .take(20)
                .onBackpressureBuffer(10)
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

    private Observable example4() {
        // onBackpressureBuffer(long, Action0)，可自定义缓冲区大小。
        // 如果缓冲区溢出，则会触发 onError，并且调用 Action0

        return Observable.interval(30, TimeUnit.MILLISECONDS)
                .take(20)
                .onBackpressureBuffer(2, new Action0() {
                    @Override
                    public void call() {
                        // 当缓冲数据超过区，将会被调用
                        RxJavaDemoUtils.LogW("onBackpressureBuffer onOverFlow");
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


