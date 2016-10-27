package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.observables.ConnectableObservable;

/**
 * Observable_share
 * <p>
 * Created by HuangYK on 16/10/25.
 */
public class MainListWithExample_Observable_share extends MainListWithExample_Observable {

    public MainListWithExample_Observable_share() {
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_serialize_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_share;
    }

    @SuppressWarnings("unchecked")
    private void example1() {
        // share()  == publish().refCount();


        System.out.println("<========before refCount()=======>");

        ConnectableObservable connectableObservable = Observable.range(1, 50000).sample(10, TimeUnit.MILLISECONDS).publish();

        connectableObservable.subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted1.");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError1: " + e.getMessage());
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("onNext1: " + integer);
            }
        });

        connectableObservable.subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted2.");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError2: " + e.getMessage());
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("onNext2: " + integer);
            }
        });

        connectableObservable.connect();

        System.out.println("<========after refCount()=======>");

        Observable observable = connectableObservable.refCount();

        observable.subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted3.");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError3: " + e.getMessage());
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("onNext3: " + integer);
            }
        });

        observable.subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted4.");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError4: " + e.getMessage());
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("onNext4: " + integer);
            }
        });
//        四、运行结果
//
//                <========before refCount()=======>
//        onNext1: 11653
//        onNext2: 11653
//        onNext1: 21317
//        onNext2: 21317
//        onNext1: 32731
//        onNext2: 32731
//        onNext1: 40808
//        onNext2: 40808
//        onCompleted1.
//                onCompleted2.
//                <========after refCount()=======>
//        onNext3: 15517
//        onNext3: 30592
//        onNext3: 45208
//        onCompleted3.
//                onNext4: 16052
//        onNext4: 16090
//        onNext4: 20936
//        onNext4: 31274
//        onNext4: 47841
//        onCompleted4.
    }

}


