package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Observable_debounce
 * <p/>
 * Created by HuangYK on 16/10/3.
 */
public class MainListWithExample_Observable_debounce extends MainListWithExample_Observable {


    public MainListWithExample_Observable_debounce() {
        addExample(example1());
        addExample(example2());
        addExample(example3());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_debounce_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_debounce;
    }

    private Observable example1() {
        // debounce(long timeout, java.util.concurrent.TimeUnit unit)

        return Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                if (subscriber.isUnsubscribed()) return;
                try {
                    //产生结果的间隔时间分别为100、200、300...900毫秒
                    for (int i = 1; i < 10; i++) {
                        subscriber.onNext(i);
                        Thread.sleep(i * 100);
                    }
                    subscriber.onCompleted();
                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        }).debounce(400, TimeUnit.MILLISECONDS);
    }

    private Observable example2() {
        // Observable<T> debounce(long timeout, TimeUnit unit, Scheduler scheduler)

        return Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                if (subscriber.isUnsubscribed()) return;
                try {
                    //产生结果的间隔时间分别为100、200、300...900毫秒
                    for (int i = 1; i < 10; i++) {
                        subscriber.onNext(i);
                        Thread.sleep(i * 100);
                    }
                    subscriber.onCompleted();
                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        }).debounce(400, TimeUnit.MILLISECONDS, Schedulers.io());
    }

    private Observable example3() {
        // <U> Observable<T> debounce(Func1<? super T, ? extends Observable<U>> debounceSelector)

        return Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                if (subscriber.isUnsubscribed()) return;
                try {
                    //产生结果的间隔时间分别为100、200、300...900毫秒
                    for (int i = 1; i < 10; i++) {
                        subscriber.onNext(i);
                        Thread.sleep(i * 100);
                    }
                    subscriber.onCompleted();
                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        }).debounce(new Func1<Integer, Observable<Long>>() {
            @Override
            public Observable<Long> call(Integer integer) {
                return Observable.timer(400, TimeUnit.MILLISECONDS);
                // 注意，以下这样写是没有效果滴，这里只是用来处理返回最终结果时机的逻辑
//                return Observable.range(1, integer).toList();
            }
        });
    }
}
