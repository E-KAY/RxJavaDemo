package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import java.util.ArrayList;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action2;
import rx.functions.Func0;
import rx.functions.Func1;

/**
 * Observable_concat
 * <p/>
 * Created by HuangYK on 16/10/3.
 */
public class MainListWithExample_Observable_concat extends MainListWithExample_Observable {


    public MainListWithExample_Observable_concat() {
        addExample(example1());
        addExample(example2());
        addExample(example3());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_concat_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_concat;
    }

    private Observable example1() {

        // 用法要注意，concat是按照一个接一个的顺序被检索的
        // 最多可以允许 9 个参数。
        // 官方文档有说明以列形式作为参数的方式，但是实际代码里似乎没有。
        return Observable.concat(getNameFromMemory(), getNameFromDb(), getNameFromNet());

        // 写法2：concatWith
//        mSubscription = doSubscribe(
//                getNameFromMemory()
//                        .concatWith(getNameFromDb())
//                        .concatWith(getNameFromNet()));
    }

    private Observable example2() {
        return Observable.concat(getNameFromMemory(), getNameFromDb(), getNameFromNet()).first();
    }

    private Observable example3() {
        return Observable.concat(getNameFromMemory(), getNameFromDb(), getNameFromNet())
                .collect(new Func0<ArrayList<String>>() {
                    @Override
                    public ArrayList<String> call() {
                        return new ArrayList<>();
                    }
                }, new Action2<ArrayList<String>, String>() {
                    @Override
                    public void call(ArrayList<String> strings, String s) {
                        strings.add(s);
                    }
                });
    }

    private Observable<String> getNameFromMemory() {
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("getNameFromMemory");
                subscriber.onCompleted();
            }
        });
    }

    private Observable<String> getNameFromDb() {
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(final Subscriber<? super String> subscriber) {
                subscriber.onNext("getNameFromDb");
                subscriber.onCompleted();
            }
        });
    }

    private Observable<String> getNameFromNet() {
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(final Subscriber<? super String> subscriber) {
                subscriber.onNext("getNameFromNet");
                subscriber.onCompleted();
            }
        });
    }
}
