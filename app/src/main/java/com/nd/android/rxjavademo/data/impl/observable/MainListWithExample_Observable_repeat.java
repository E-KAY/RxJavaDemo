package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import java.util.concurrent.TimeUnit;

import rx.Observable;

/**
 * Observable_repeat
 * <p>
 * Created by HuangYK on 16/10/3.
 */
public class MainListWithExample_Observable_repeat extends MainListWithExample_Observable {

    public MainListWithExample_Observable_repeat() {
        addExample(example1());
        addExample(example2());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_repeat_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_repeat;
    }

    private Observable example1() {
        // repeat()

        return Observable.just(1).repeat().delay(300, TimeUnit.MILLISECONDS);
    }

    private Observable example2() {
        // repeat(long)

        return Observable.just(1).repeat(5).delay(300, TimeUnit.MILLISECONDS);
    }
}


