package com.nd.android.rxjavademo.data.impl.observable;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.nd.android.rxjavademo.R;
import com.nd.android.rxjavademo.activity.observable.ObservableShowExampleActivity;
import com.nd.android.rxjavademo.data.IMainListData;
import com.nd.android.rxjavademo.data.IMainListWithExampleData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import rx.Observable;

/**
 * 带有展示例子的Observable数据基类
 * <p/>
 * Created by HuangYK on 16/10/3.
 */
public abstract class MainListWithExample_Observable<T> implements IMainListWithExampleData {

    protected HashMap<Integer, Integer> mRequestMap = new HashMap<>();
    protected List<Observable<T>> mExampleList = new ArrayList<>();

    @Override
    public void starActivity(Context context) {
        ObservableShowExampleActivity.starActivity(context, getSubTitle());
    }

    @SuppressWarnings("unchecked")
    @Override
    public Observable getExample(int index) {
        if (index >= 0 && index < mExampleList.size()) {
            return mExampleList.get(index);
        }
        return null;
    }

    @Override
    public int getRequest(int index) {
        return mRequestMap.containsKey(index) ? mRequestMap.get(index) : 0;
    }

    @Override
    public int getMainTitle() {
        return R.string.str_mainlist_Observable;
    }

    @Override
    public void addExample(@NonNull Observable example) {
        this.addExample(example, 0);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void addExample(@NonNull Observable example, int request) {
        mRequestMap.put(mExampleList.size(), request);
        mExampleList.add(example);
    }

    @Override
    public int getExampleSize() {
        return mExampleList.size();
    }

    @SuppressWarnings("unchecked")
    @Override
    public Observable<T> getSubjectAsObservable() {
        return null;
    }


//    @Override
//    public int compareTo(@NonNull Object another) {
//        if (!(another instanceof IMainListData)) {
//            return 1;
//        }
//        IMainListData anotherData = (IMainListData) another;
//
//        int result;
//        if (this.getSubTitle() > anotherData.getSubTitle()) {
//            result = 1;
//        } else if (this.getSubTitle() < anotherData.getSubTitle()) {
//            result = -1;
//        } else {
//            result = 0;
//        }
//        Log.e("HYK", "result = " + result + " , this.getSubTitle() = " + this.getSubTitle() + " , anotherData.getSubTitle() = " + anotherData.getSubTitle());
//        return result;
//    }
}
