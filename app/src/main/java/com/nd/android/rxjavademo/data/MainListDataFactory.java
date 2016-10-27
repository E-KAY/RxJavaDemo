package com.nd.android.rxjavademo.data;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;

import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_all;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_amb;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_asObservable;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_buffer;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_cache;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_cast;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_collect;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_combineLatest;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_compose;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_concat;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_concatMap;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_contains;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_count;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_create;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_debounce;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_defaultIfjEmpty;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_defer;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_delay;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_dematerialize;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_distinct;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_distinctUntilChanged;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_elementAt;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_empty;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_error;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_exists;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_filter;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_first;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_firstOrDefault;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_flatMap;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_flatMapIterable;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_forEach;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_from;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_fromCallable;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_groupBy;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_groupJoin;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_ignoreElements;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_interval;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_isEmpty;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_join;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_just;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_last;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_lastOrDefault;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_limit;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_map;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_materialize;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_merge;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_mergeDelayError;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_nest;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_never;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_observeOn;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_ofType;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_onBackpressureBuffer;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_onBackpressureDrop;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_onBackpressureLatest;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_onErrorResumeNext;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_onErrorReturn;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_onExceptionResumeNext;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_publish;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_range;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_reduce;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_repeat;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_repeatWhen;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_replay;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_retry;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_retryWhen;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_sample;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_scan;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_sequenceEqual;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_serialize;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_share;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_single;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_singleOrDefault;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_skip;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_skipLast;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_skipUntil;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_skipWhile;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_sorted;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_startWith;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_subscribe;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_subscribeOn;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_switchIfEmpty;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_switchMap;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_switchOnNext;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_take;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_takeFirst;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_takeLast;
import com.nd.android.rxjavademo.data.impl.observable.MainListWithExample_Observable_takeLastBuffer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * MainListDataFactory
 * <p/>
 * Created by HuangYK on 16/8/30.
 */
public final class MainListDataFactory {

    private static MainListDataFactory sInstance = null;

    public static MainListDataFactory getInstance() {
        if (sInstance == null) {
            synchronized (MainListDataFactory.class) {
                if (sInstance == null) {
                    sInstance = new MainListDataFactory();
                }
            }
        }
        return sInstance;
    }

    @SuppressLint("UseSparseArrays")
    private Map<Integer, IMainListData> mMainListDataMap = new HashMap<>();

    private MainListDataFactory() {
        initMainListData();
    }

    private void initMainListData() {
        // Observable
        requestMainListData(new MainListWithExample_Observable_all());
        requestMainListData(new MainListWithExample_Observable_amb());
        requestMainListData(new MainListWithExample_Observable_asObservable());
        requestMainListData(new MainListWithExample_Observable_buffer());
        requestMainListData(new MainListWithExample_Observable_cache());
        requestMainListData(new MainListWithExample_Observable_cast());
        requestMainListData(new MainListWithExample_Observable_collect());
        requestMainListData(new MainListWithExample_Observable_combineLatest());
        requestMainListData(new MainListWithExample_Observable_compose());
        requestMainListData(new MainListWithExample_Observable_concat());
        requestMainListData(new MainListWithExample_Observable_concatMap());
        requestMainListData(new MainListWithExample_Observable_contains());
        requestMainListData(new MainListWithExample_Observable_count());
        requestMainListData(new MainListWithExample_Observable_create());
        requestMainListData(new MainListWithExample_Observable_debounce());
        requestMainListData(new MainListWithExample_Observable_defaultIfjEmpty());
        requestMainListData(new MainListWithExample_Observable_defer());
        requestMainListData(new MainListWithExample_Observable_delay());
        requestMainListData(new MainListWithExample_Observable_dematerialize());
        requestMainListData(new MainListWithExample_Observable_distinct());
        requestMainListData(new MainListWithExample_Observable_distinctUntilChanged());
        requestMainListData(new MainListWithExample_Observable_elementAt());
        requestMainListData(new MainListWithExample_Observable_empty());
        requestMainListData(new MainListWithExample_Observable_error());
        requestMainListData(new MainListWithExample_Observable_exists());
        requestMainListData(new MainListWithExample_Observable_filter());
        requestMainListData(new MainListWithExample_Observable_first());
        requestMainListData(new MainListWithExample_Observable_firstOrDefault());
        requestMainListData(new MainListWithExample_Observable_flatMap());
        requestMainListData(new MainListWithExample_Observable_flatMapIterable());
        requestMainListData(new MainListWithExample_Observable_forEach());
        requestMainListData(new MainListWithExample_Observable_from());
        requestMainListData(new MainListWithExample_Observable_fromCallable());
        requestMainListData(new MainListWithExample_Observable_groupBy());
        requestMainListData(new MainListWithExample_Observable_groupJoin());
        requestMainListData(new MainListWithExample_Observable_ignoreElements());
        requestMainListData(new MainListWithExample_Observable_interval());
        requestMainListData(new MainListWithExample_Observable_isEmpty());
        requestMainListData(new MainListWithExample_Observable_join());
        requestMainListData(new MainListWithExample_Observable_just());
        requestMainListData(new MainListWithExample_Observable_last());
        requestMainListData(new MainListWithExample_Observable_lastOrDefault());
        requestMainListData(new MainListWithExample_Observable_limit());
        requestMainListData(new MainListWithExample_Observable_map());
        requestMainListData(new MainListWithExample_Observable_materialize());
        requestMainListData(new MainListWithExample_Observable_merge());
        requestMainListData(new MainListWithExample_Observable_mergeDelayError());
        requestMainListData(new MainListWithExample_Observable_nest());
        requestMainListData(new MainListWithExample_Observable_never());
        requestMainListData(new MainListWithExample_Observable_observeOn());
        requestMainListData(new MainListWithExample_Observable_ofType());
        requestMainListData(new MainListWithExample_Observable_onBackpressureBuffer());
        requestMainListData(new MainListWithExample_Observable_onBackpressureDrop());
        requestMainListData(new MainListWithExample_Observable_onBackpressureLatest());
        requestMainListData(new MainListWithExample_Observable_onErrorResumeNext());
        requestMainListData(new MainListWithExample_Observable_onErrorReturn());
        requestMainListData(new MainListWithExample_Observable_onExceptionResumeNext());
        requestMainListData(new MainListWithExample_Observable_publish());
        requestMainListData(new MainListWithExample_Observable_range());
        requestMainListData(new MainListWithExample_Observable_reduce());
        requestMainListData(new MainListWithExample_Observable_repeat());
        requestMainListData(new MainListWithExample_Observable_repeatWhen());
        requestMainListData(new MainListWithExample_Observable_replay());
        requestMainListData(new MainListWithExample_Observable_retry());
        requestMainListData(new MainListWithExample_Observable_retryWhen());
        requestMainListData(new MainListWithExample_Observable_sample());
        requestMainListData(new MainListWithExample_Observable_scan());
        requestMainListData(new MainListWithExample_Observable_sequenceEqual());
        requestMainListData(new MainListWithExample_Observable_serialize());
        requestMainListData(new MainListWithExample_Observable_share());
        requestMainListData(new MainListWithExample_Observable_single());
        requestMainListData(new MainListWithExample_Observable_singleOrDefault());
        requestMainListData(new MainListWithExample_Observable_skip());
        requestMainListData(new MainListWithExample_Observable_skipLast());
        requestMainListData(new MainListWithExample_Observable_skipUntil());
        requestMainListData(new MainListWithExample_Observable_skipWhile());
        requestMainListData(new MainListWithExample_Observable_sorted());
        requestMainListData(new MainListWithExample_Observable_startWith());
        requestMainListData(new MainListWithExample_Observable_subscribe());
        requestMainListData(new MainListWithExample_Observable_subscribeOn());
        requestMainListData(new MainListWithExample_Observable_switchIfEmpty());
        requestMainListData(new MainListWithExample_Observable_switchMap());
        requestMainListData(new MainListWithExample_Observable_switchOnNext());
        requestMainListData(new MainListWithExample_Observable_take());
        requestMainListData(new MainListWithExample_Observable_takeFirst());
        requestMainListData(new MainListWithExample_Observable_takeLast());
        requestMainListData(new MainListWithExample_Observable_takeLastBuffer());







        // Schedulers
//        mMainListDatas.add(new MainListData_Schedulers());
    }

    public List<IMainListData> getMainListDatas() {
        return new ArrayList<>(mMainListDataMap.values());
    }

    public IMainListData getMainListData(int key) {
        if (mMainListDataMap.containsKey(key)) {
            return mMainListDataMap.get(key);
        }
        return null;
    }


    private void requestMainListData(@NonNull IMainListData mainListData) {
        mMainListDataMap.put(mainListData.getSubTitle(), mainListData);
    }


}
