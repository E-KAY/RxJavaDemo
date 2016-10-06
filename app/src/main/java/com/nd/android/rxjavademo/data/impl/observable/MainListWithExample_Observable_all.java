package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import rx.Observable;
import rx.functions.Func1;

/**
 * Observable_all
 * <p/>
 * Created by HuangYK on 16/10/3.
 */
public class MainListWithExample_Observable_all extends MainListWithExample_Observable {

    public MainListWithExample_Observable_all() {
        addExample(example1());
        addExample(example2());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_all_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_all;
    }


    private Observable example1() {
        return Observable.just(1, 2, 3, 4).compose(doAllOperator());
    }

    public Observable example2() {
        return Observable.just(1, 2, 3, 4, 5).compose(doAllOperator());
    }


    // 为什么要这么写，在compose中有说明...
    private Observable.Transformer<Integer, Boolean> doAllOperator() {
        return new Observable.Transformer<Integer, Boolean>() {
            @Override
            public Observable<Boolean> call(Observable<Integer> tObservable) {
                return tObservable.all(new Func1<Integer, Boolean>() {
                    @Override
                    public Boolean call(Integer integer) {
                        return integer < 5;
                    }
                });
            }
        };
    }
}
