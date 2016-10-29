package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import rx.Observable;
import rx.functions.Func1;

/**
 * Observable_to
 * <p>
 * Created by HuangYK on 16/10/27.
 */
public class MainListWithExample_Observable_to extends MainListWithExample_Observable {

    public MainListWithExample_Observable_to() {
        addExample(example1());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_to_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_to;
    }

    private Observable example1() {
        return Observable.just(
                Observable.range(1, 5).to(new Func1<Observable<Integer>, Observable<String>>() {
                    @Override
                    public Observable<String> call(Observable<Integer> integerObservable) {
                        return integerObservable.map(new Func1<Integer, String>() {
                            @Override
                            public String call(Integer integer) {
                                return "to - " + integer;
                            }
                        });
                    }
                }));
    }

}
