package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;

/**
 * Observable_amb
 * <p/>
 * Created by HuangYK on 16/10/3.
 */
public class MainListWithExample_Observable_amb extends MainListWithExample_Observable {


    public MainListWithExample_Observable_amb() {
        addExample(example1());
        addExample(example2());
        addExample(example3());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_amb_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_amb;
    }


    private Observable example1() {
        Observable<Integer> delay1 = Observable.just(1, 2, 3).delay(3000, TimeUnit.MILLISECONDS);
        Observable<Integer> delay2 = Observable.just(4, 5, 6).delay(1000, TimeUnit.MILLISECONDS);
        Observable<Integer> delay3 = Observable.just(7, 8, 9).delay(2000, TimeUnit.MILLISECONDS);

        return Observable.amb(delay1, delay2, delay3);
    }

    private Observable example2() {
        Observable<Integer> delay1 = Observable.just(1, 2, 3).delay(3000, TimeUnit.MILLISECONDS);
        Observable<Integer> delay2 = Observable.just(4, 5, 6).delay(1000, TimeUnit.MILLISECONDS);
        Observable<Integer> delay3 = Observable.just(7, 8, 9).delay(2000, TimeUnit.MILLISECONDS);
        Observable<Integer> delay4 = Observable.just(7, 8).delay(2100, TimeUnit.MILLISECONDS);
        Observable<Integer> delay5 = Observable.just(8, 9).delay(1100, TimeUnit.MILLISECONDS);
        Observable<Integer> delay6 = Observable.just(1, 2).delay(1200, TimeUnit.MILLISECONDS);
        Observable<Integer> delay7 = Observable.just(2, 3).delay(1300, TimeUnit.MILLISECONDS);
        Observable<Integer> delay8 = Observable.just(0, 1).delay(1400, TimeUnit.MILLISECONDS);
        Observable<Integer> delay9 = Observable.just(5, 6).delay(1500, TimeUnit.MILLISECONDS);
        Observable<Integer> delay10 = Observable.just(1, 2, 3, 4, 5, 6, 7, 8).delay(900, TimeUnit.MILLISECONDS);

        List<Observable<Integer>> observables = new ArrayList<>();
        observables.add(delay1);
        observables.add(delay2);
        observables.add(delay3);
        observables.add(delay4);
        observables.add(delay5);
        observables.add(delay6);
        observables.add(delay7);
        observables.add(delay8);
        observables.add(delay9);
        observables.add(delay10);

        return Observable.amb(observables);
    }

    private Observable example3() {
        Observable<Integer> delay1 = Observable.just(1, 2, 3).delay(3000, TimeUnit.MILLISECONDS);
        Observable<Integer> delay2 = Observable.just(4, 5, 6).delay(1000, TimeUnit.MILLISECONDS);
        Observable<Integer> delay3 = Observable.just(7, 8, 9).delay(2000, TimeUnit.MILLISECONDS);

        return delay1.ambWith(delay2).ambWith(delay3);
    }
}
