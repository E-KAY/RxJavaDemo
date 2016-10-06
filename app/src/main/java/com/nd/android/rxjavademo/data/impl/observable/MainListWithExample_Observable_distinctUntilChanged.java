package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.functions.Func1;

/**
 * Observable_distinctUntilChanged
 * <p/>
 * Created by HuangYK on 16/10/3.
 */
public class MainListWithExample_Observable_distinctUntilChanged extends MainListWithExample_Observable {

    public MainListWithExample_Observable_distinctUntilChanged() {
        addExample(example1());
        addExample(example2());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_distinctUntilChanged_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_distinctUntilChanged;
    }

    private Observable example1() {
        // Observable<T> distinctUntilChanged()

        return Observable.from(getList()).distinctUntilChanged();
    }

    private Observable example2() {
        // <U> Observable<T> distinctUntilChanged(Func1<? super T, ? extends U> keySelector)

        return Observable.from(getList())
                .distinctUntilChanged(new Func1<Integer, Integer>() {
                    @Override
                    public Integer call(Integer integer) {
                        return integer;
                    }
                });
    }


    private List<Integer> getList() {
        return new ArrayList<Integer>() {
            {
                add(1);
                add(2);
                add(2);
                add(3);
                add(4);
                add(4);
                add(5);
                add(6);
                add(7);
                add(7);
            }
        };
    }
}
