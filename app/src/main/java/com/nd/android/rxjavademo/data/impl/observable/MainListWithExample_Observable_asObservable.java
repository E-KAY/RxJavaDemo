package com.nd.android.rxjavademo.data.impl.observable;

import android.database.DataSetObserver;
import android.support.annotation.NonNull;

import com.nd.android.rxjavademo.R;
import com.nd.android.rxjavademo.utils.ObservableArrayList;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.subjects.BehaviorSubject;

/**
 * Observable_asObservable
 * <p/>
 * Created by HuangYK on 16/10/3.
 */
public class MainListWithExample_Observable_asObservable extends MainListWithExample_Observable {

    private DataSetObserver mCallback = new DataSetObserver() {
        @Override
        public void onChanged() {
            super.onChanged();
            mListPublishSubject.onNext(mDataList);
        }
    };
    @NonNull
    private final ObservableArrayList<Long> mDataList = new ObservableArrayList<>(mCallback);
    private BehaviorSubject<ObservableArrayList<Long>> mListPublishSubject = BehaviorSubject.create();


    public MainListWithExample_Observable_asObservable() {
        addExample(example1());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_asObservable_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_asObservable;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Observable<ObservableArrayList<Long>> getSubjectAsObservable() {
        return mListPublishSubject.asObservable();
    }

    private Observable example1() {
        return Observable.merge(observable1(), observable2())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Action1<Long>() {
                    @Override
                    public void call(Long integer) {
                        mDataList.add(integer);
                    }
                });
    }

    private Observable<Long> observable1() {
        return Observable.interval(300, TimeUnit.MILLISECONDS)
                .map(new Func1<Long, Long>() {
                    @Override
                    public Long call(Long aLong) {
                        return aLong * 10;
                    }
                }).take(5);
    }

    private Observable<Long> observable2() {
        return Observable.interval(500, TimeUnit.MILLISECONDS)
                .map(new Func1<Long, Long>() {
                    @Override
                    public Long call(Long aLong) {
                        return aLong * 100;
                    }
                }).take(5);
    }
}
