package com.nd.android.rxjavademo.data;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;

import com.nd.android.rxjavademo.data.impl.observable.*;

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
        requestMainListData(new MainListWithExample_Observable_takeUntil());
        requestMainListData(new MainListWithExample_Observable_takeWhile());
        requestMainListData(new MainListWithExample_Observable_throttleFirst());
        requestMainListData(new MainListWithExample_Observable_throttleLast());
        requestMainListData(new MainListWithExample_Observable_throttleWithTimeout());
        requestMainListData(new MainListWithExample_Observable_timeInterval());
        requestMainListData(new MainListWithExample_Observable_timeout());
        requestMainListData(new MainListWithExample_Observable_timer());
        requestMainListData(new MainListWithExample_Observable_timestamp());
        requestMainListData(new MainListWithExample_Observable_to());
        requestMainListData(new MainListWithExample_Observable_toBlocking());
        requestMainListData(new MainListWithExample_Observable_toCompletable());
        requestMainListData(new MainListWithExample_Observable_toList());
        requestMainListData(new MainListWithExample_Observable_toMap());
        requestMainListData(new MainListWithExample_Observable_toMultiMap());
        requestMainListData(new MainListWithExample_Observable_toSingle());
        requestMainListData(new MainListWithExample_Observable_toSortedList());
        requestMainListData(new MainListWithExample_Observable_unsafeSubscribe());
        requestMainListData(new MainListWithExample_Observable_unsubscribeOn());
        requestMainListData(new MainListWithExample_Observable_using());
        requestMainListData(new MainListWithExample_Observable_window());
        requestMainListData(new MainListWithExample_Observable_withLatestFrom());
        requestMainListData(new MainListWithExample_Observable_zip());
        requestMainListData(new MainListWithExample_Observable_zipWith());







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
