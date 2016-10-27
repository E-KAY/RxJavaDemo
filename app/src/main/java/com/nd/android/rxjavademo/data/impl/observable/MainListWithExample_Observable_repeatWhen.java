package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Func1;

/**
 * Observable_repeatWhen
 * <p>
 * Created by HuangYK on 16/10/3.
 */
public class MainListWithExample_Observable_repeatWhen extends MainListWithExample_Observable {

    public MainListWithExample_Observable_repeatWhen() {
        addExample(example1());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_repeatWhen_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_repeatWhen;
    }

    private Observable example1() {
        // repeatWhen(Func1)

        // 首次订阅后的 1 秒再订阅一次
        return Observable.range(1, 3).repeatWhen(new Func1<Observable<? extends Void>, Observable<?>>() {
            @Override
            public Observable<?> call(Observable<? extends Void> observable) {
                return Observable.timer(1000, TimeUnit.MILLISECONDS);
            }
        });
    }

}


