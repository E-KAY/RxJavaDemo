package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Action2;
import rx.functions.Func0;
import rx.functions.Func3;
import rx.observables.AsyncOnSubscribe;

/**
 * Observable_create
 * <p/>
 * Created by HuangYK on 16/10/3.
 */
public class MainListWithExample_Observable_create extends MainListWithExample_Observable {


    public MainListWithExample_Observable_create() {
        addExample(example1());
        addExample(example2());
        addExample(example3(), 10);
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_create_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_create;
    }

    private Observable example1() {
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("example1");
                subscriber.onCompleted();
            }
        });
    }

    // 暂时不用深入研究
    private Observable example2() {
        return Observable.create(AsyncOnSubscribe.createStateful(
                new Func0<Integer>() {
                    @Override
                    public Integer call() {
                        return 1;
                    }
                },
                new Func3<Integer, Long, Observer<Observable<? extends Integer>>, Integer>() {
                    @Override
                    public Integer call(Integer state, Long requested, Observer<Observable<? extends Integer>> observer) {
                        if (state == 1) {
                            Observable<Integer> o1 = Observable.just(1, 2, 3, 4)
                                    .delay(300, TimeUnit.MILLISECONDS);
                            observer.onNext(o1);
                        } else if (state == 2) {
                            Observable<Integer> o = Observable.just(5, 6, 7, 8);
                            observer.onNext(o);
                        } else
                            observer.onCompleted();
                        return state + 1;
                    }
                }));
    }

    // 暂时不用深入研究
    private Observable example3() {
        return Observable.create(AsyncOnSubscribe.createStateless(
                new Action2<Long, Observer<Observable<? extends Integer>>>() {
                    @Override
                    public void call(Long requested, Observer<Observable<? extends Integer>> observer) {
                        observer.onNext(Observable.range(1, requested.intValue()));
                        observer.onCompleted();
                    }
                }));
    }
}
