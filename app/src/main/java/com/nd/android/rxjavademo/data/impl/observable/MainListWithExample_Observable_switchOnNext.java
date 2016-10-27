package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * Observable_switchOnNext
 * <p>
 * Created by HuangYK on 16/10/25.
 */
public class MainListWithExample_Observable_switchOnNext extends MainListWithExample_Observable {

    public MainListWithExample_Observable_switchOnNext() {
        addExample(example1());
        addExample(example2());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_switchOnNext_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_switchOnNext;
    }

    private Observable example1() {
        return Observable.switchOnNext(Observable.create(new Observable.OnSubscribe<Observable<String>>() {
            @Override
            public void call(final Subscriber<? super Observable<String>> subscriber) {

                for (int i = 1; i < 5; i++) {
                    final int finalI = i;
                    subscriber.onNext(Observable.interval(0, finalI * 300, TimeUnit.MILLISECONDS).take(10).map(new Func1<Long, String>() {
                        @Override
                        public String call(Long aLong) {
                            return finalI + "-" + aLong;
                        }
                    }));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }));
    }


    private Observable example2() {
        // 这个例子是 不加 switchOnNext

        return Observable.create(new Observable.OnSubscribe<Observable<String>>() {
            @Override
            public void call(final Subscriber<? super Observable<String>> subscriber) {

                for (int i = 1; i < 5; i++) {
                    final int finalI = i;
                    subscriber.onNext(Observable.interval(0, finalI * 300, TimeUnit.MILLISECONDS).take(10).map(new Func1<Long, String>() {
                        @Override
                        public String call(Long aLong) {
                            return finalI + "-" + aLong;
                        }
                    }));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }


}
