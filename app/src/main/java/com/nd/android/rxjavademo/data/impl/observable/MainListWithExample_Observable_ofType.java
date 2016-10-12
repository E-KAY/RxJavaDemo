package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;
import com.nd.android.rxjavademo.utils.RxJavaDemoUtils;

import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Observable_ofType
 * <p/>
 * Created by HuangYK on 16/10/3.
 */
public class MainListWithExample_Observable_ofType extends MainListWithExample_Observable {

    public MainListWithExample_Observable_ofType() {
        addExample(example1());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_ofType_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_ofType;
    }

    private Observable example1() {
        return Observable.just("1", "2", 3, 4, "5").ofType(Integer.class);
    }
}


