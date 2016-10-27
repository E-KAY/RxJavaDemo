package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * Observable_retryWhen
 * <p>
 * Created by HuangYK on 16/10/24.
 */
public class MainListWithExample_Observable_retryWhen extends MainListWithExample_Observable {

    public MainListWithExample_Observable_retryWhen() {
        addExample(example1());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_retryWhen_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_retryWhen;
    }

    private Observable example1() {
        final List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("3");
        list.add("3");
        list.add("4");

        final String three = "3";

        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext(list.toString());
                if (list.contains(three)) {
                    subscriber.onError(new Throwable("403"));
                    return;
                }
                subscriber.onCompleted();
            }
        }).retryWhen(new Func1<Observable<? extends Throwable>, Observable<?>>() {
            @Override
            public Observable<?> call(Observable<? extends Throwable> observable) {
                return observable.flatMap(new Func1<Throwable, Observable<?>>() {
                    @Override
                    public Observable<?> call(Throwable throwable) {
                        if (throwable.getMessage().equals("403")) {
                            int index = list.indexOf(three);

                            if (index >= 0 && list.remove(index).equals(three)) {
                                return Observable.just(null);
                            }
                        }
                        return Observable.error(throwable);
                    }
                });
            }
        });
    }
}


