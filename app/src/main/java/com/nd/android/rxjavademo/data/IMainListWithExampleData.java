package com.nd.android.rxjavademo.data;

import android.support.annotation.NonNull;
import android.support.annotation.StringRes;

import rx.Observable;

/**
 * 主界面内容列表数据接口
 * <p/>
 * Created by HuangYK on 16/8/29.
 */
public interface IMainListWithExampleData extends IMainListData {

    @StringRes
    int getDetailInfo();

    <T> Observable<T> getExample(int index);

    int getRequest(int index);

    void addExample(@NonNull Observable example);

    void addExample(@NonNull Observable example, int request);

    int getExampleSize();

    <T> Observable<T> getSubjectAsObservable();

}
