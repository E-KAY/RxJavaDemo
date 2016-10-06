package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

/**
 * Observable_defaultIfEmpty
 * <p/>
 * Created by HuangYK on 16/10/3.
 */
public class MainListWithExample_Observable_defaultIfjEmpty extends MainListWithExample_Observable {


    public MainListWithExample_Observable_defaultIfjEmpty() {
        addExample(example1());
        addExample(example2());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_defaultIfEmpty_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_defaultIfEmpty;
    }

    private Observable example1() {
        return Observable.from(new ArrayList<String>())
                .defaultIfEmpty("example1 defaultValue");
    }

    private Observable example2() {
        List<String> normalList = new ArrayList<>();
        normalList.add("observableExample2 normal value");

        return Observable.from(normalList).defaultIfEmpty("observableExample1 default value");
    }

}
