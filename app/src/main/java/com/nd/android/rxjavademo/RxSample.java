package com.nd.android.rxjavademo;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * Created by Chenll on 2016/8/23 0023.
 */
public class RxSample {

    public Observable<String> onNext() {
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("1");
                subscriber.onNext("2");
                subscriber.onCompleted();
                subscriber.onNext("3");
            }
        });
    }

    public Observable<String> just() {
        return Observable.just("Hello");
    }

    public Observable<String> from() {
        return Observable.from(new String[]{
                "1", "2", "3"
        });
    }

    public Observable<String> filter() {
        return Observable
                .from(new String[]{
                        "1", "2", "3", "2"
                })
                .filter(new Func1<String, Boolean>() {
                    @Override
                    public Boolean call(String s) {
                        return "2".equalsIgnoreCase(s);
                    }
                });
    }

    public Observable<Integer> map() {
        return Observable
                .just("1")
                .map(new Func1<String, Integer>() {
                    @Override
                    public Integer call(String s) {
                        return Integer.valueOf(s);
                    }
                });
    }

    public Observable<String> flatMap() {
        return Observable
                .just(291212L)
                .flatMap(new Func1<Long, Observable<String>>() {
                    @Override
                    public Observable<String> call(Long uid) {
                        return getToken(291212L);
                    }
                })
                .flatMap(new Func1<String, Observable<String>>() {
                    @Override
                    public Observable<String> call(String token) {
                        return login(token);
                    }
                });
    }

    private Observable<String> login(String token) {
        return Observable.just(token + " login");
    }

    private Observable<String> getToken(long uid) {
        return Observable.just(uid + " token");
    }

    public Observable<String> lift() {
        return Observable
                .just(291212L)
                .lift(new Observable.Operator<String, Long>() {
                    @Override
                    public Subscriber<? super Long> call(final Subscriber<? super String> subscriber) {
                        return new Subscriber<Long>() {
                            @Override
                            public void onCompleted() {
                                subscriber.onCompleted();
                            }

                            @Override
                            public void onError(Throwable e) {
                                subscriber.onError(e);
                            }

                            @Override
                            public void onNext(Long aLong) {
                                subscriber.onNext("" + aLong);
                            }
                        };
                    }
                });
    }

}
