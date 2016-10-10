package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Func1;

/**
 * Observable_mergeDelayError
 * <p/>
 * Created by HuangYK on 16/10/3.
 */
public class MainListWithExample_Observable_mergeDelayError extends MainListWithExample_Observable {

    public MainListWithExample_Observable_mergeDelayError() {
        addExample(example1());
        addExample(example2());
        addExample(example3());
        addExample(example4());
        addExample(example5());
        addExample(example6());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_mergeDelayError_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_mergeDelayError;
    }

    private Observable example1() {

        List<Observable<Long>> observables = new ArrayList<>();
        observables.add(getObservable1());
        observables.add(getObservable2());

        return Observable.merge(observables);
    }

    private Observable example2() {
        List<Observable<Long>> observables = new ArrayList<>();
        observables.add(getObservable1());
        observables.add(getObservable1());
        observables.add(getObservable2());
        observables.add(getObservable2());

        return Observable.merge(observables, 2);
    }

    private Observable example3() {
        Observable[] observables = new Observable[]{
                getObservable1(),
                getObservable2()
        };
        return Observable.merge(observables);
    }

    private Observable example4() {
        Observable[] observables = new Observable[]{
                getObservable1(),
                getObservable1(),
                getObservable2(),
                getObservable2()
        };
        return Observable.merge(observables, 2);
    }

    private Observable example5() {
        return Observable.merge(getObservable1(), getObservable2());
    }

    private Observable example6() {
        return Observable.merge(Observable.just(Observable.interval(0, 500, TimeUnit.MILLISECONDS).take(10)));
    }


    private Observable<Long> getObservable1() {
        return Observable.interval(500, TimeUnit.MILLISECONDS).map(new Func1<Long, Long>() {
            @Override
            public Long call(Long aLong) {
                if (aLong > 2) {
                    throw new RuntimeException();
                }
                return aLong;
            }
        }).take(5);
    }

    private Observable<Long> getObservable2() {
        return Observable.interval(300, 500, TimeUnit.MILLISECONDS)
                .map(new Func1<Long, Long>() {
                    @Override
                    public Long call(Long aLong) {
                        return aLong * 10;
                    }
                }).take(5);
    }


}
