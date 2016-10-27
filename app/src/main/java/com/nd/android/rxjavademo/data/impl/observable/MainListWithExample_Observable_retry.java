package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func2;

/**
 * Observable_retry
 * <p>
 * Created by HuangYK on 16/10/24.
 */
public class MainListWithExample_Observable_retry extends MainListWithExample_Observable {

    public MainListWithExample_Observable_retry() {
        addExample(example1());
        addExample(example2());
        addExample(example3());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_retry_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_retry;
    }

    private Observable example1() {

        final List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("3");
        list.add("4");

        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext(list.toString());

                if (list.contains("3")) {
                    list.remove(list.indexOf("3"));
                    subscriber.onError(new Throwable("string.equals(\"3\")"));
                }
                subscriber.onCompleted();
            }
        }).retry();
    }

    private Observable example2() {

        final List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("3");
        list.add("3");
        list.add("4");

        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext(list.toString());

                if (list.contains("3")) {
                    list.remove(list.indexOf("3"));
                    subscriber.onError(new Throwable("string.equals(\"3\")"));
                }
                subscriber.onCompleted();
            }
        }).retry(3);
    }

    private Observable example3() {
        final List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("3");
        list.add("3");
        list.add("4");

        final String three = "3";

        // 这里比较奇怪的是，第一次执行不会走到 retry 里的 Func2
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                if (list.contains(three)) {
                    subscriber.onError(new Throwable("403"));
                    return;
                }
                subscriber.onNext(list.toString());
                subscriber.onCompleted();
            }
        }).retry(new Func2<Integer, Throwable, Boolean>() {
            @Override
            public Boolean call(Integer integer, Throwable throwable) {
                if (integer < 3 && throwable.getMessage().equals("403")) {

                    int index = list.indexOf(three);

                    if (index >= 0 && list.remove(index).equals(three)) {
                        return true;
                    }
                }
                return false;
            }
        }).serialize();
    }

}


