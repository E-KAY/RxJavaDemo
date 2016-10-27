package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;
import com.nd.android.rxjavademo.utils.RxJavaDemoUtils;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;

/**
 * Observable_subscribeOn
 * <p>
 * Created by HuangYK on 16/10/25.
 */
public class MainListWithExample_Observable_subscribeOn extends MainListWithExample_Observable {

    public MainListWithExample_Observable_subscribeOn() {
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_subscribeOn_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_subscribeOn;
    }

    private void example1() {
        Observable
                .create(new Observable.OnSubscribe<String>() {
                    @Override
                    public void call(Subscriber<? super String> subscriber) {
                        RxJavaDemoUtils.threadInfo("OnSubscribe.call()");
                        subscriber.onNext("RxJava");
                    }
                })
                .subscribeOn(RxJavaDemoUtils.getNamedScheduler("create之后的subscribeOn"))
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        RxJavaDemoUtils.threadInfo(".doOnSubscribe()-1");
                    }
                })
                .subscribeOn(RxJavaDemoUtils.getNamedScheduler("doOnSubscribe1之后的subscribeOn"))
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        RxJavaDemoUtils.threadInfo(".doOnSubscribe()-2");
                    }
                })
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        RxJavaDemoUtils.threadInfo(".onNext()");
                    }
                });
    }


}
