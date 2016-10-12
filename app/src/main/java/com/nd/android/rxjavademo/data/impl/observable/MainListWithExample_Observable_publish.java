package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import rx.Observable;
import rx.functions.Func1;

/**
 * Observable_publish
 * <p>
 * Created by HuangYK on 16/10/3.
 */
public class MainListWithExample_Observable_publish extends MainListWithExample_Observable {

    public MainListWithExample_Observable_publish() {
        addExample(example1());
        addExample(example2());
        addExample(example3());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_publish_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_publish;
    }

    private Observable example1() {
        // 这样写 Observable 是不会开始执行的，即使调用了 subscribe，因为它已经被转成了 ConnectableObservable
        return Observable.just(101).publish();
    }

    private Observable example2() {
        return Observable.just(101).publish().autoConnect();
    }

    private Observable example3() {
        // publish(Func1)，支持对数据进行一次处理，类似 map 的功能

        return Observable.range(1, 10).publish(new Func1<Observable<Integer>, Observable<Integer>>() {
            @Override
            public Observable<Integer> call(Observable<Integer> observable) {
                return observable.map(new Func1<Integer, Integer>() {
                    @Override
                    public Integer call(Integer integer) {
                        return integer * 2;
                    }
                });
            }
        });
    }
}


