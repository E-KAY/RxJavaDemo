package com.nd.android.rxjavademo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.BaseAdapter;

import com.nd.android.rxjavademo.utils.RxJavaDemoUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * BaseAdapter，do some basic settings
 * <p/>
 * Created by HuangYK on 16/8/4.
 */
public abstract class RJDBaseAdapter<T> extends BaseAdapter {

    protected Context mContext;
    protected List<T> mDataList = new ArrayList<>();

    public RJDBaseAdapter(@NonNull Context context) {
        mContext = context;
    }

    public RJDBaseAdapter(@NonNull Context context, List<T> dataList) {
        mContext = context;
        mDataList = dataList;
    }

    public void setDataList(List<T> dataList) {
        mDataList = dataList;
        notifyDataSetChanged();
    }

    public void addDataList(List<T> dataList) {
        if (RxJavaDemoUtils.isEmptyList(dataList)) {
            return;
        }
        if (mDataList == null) {
            mDataList = new ArrayList<>();
        }
        mDataList.addAll(dataList);
        notifyDataSetChanged();
    }

    public List<T> getDataList() {
        if (mDataList == null) {
            mDataList = new ArrayList<>();
        }
        return mDataList;
    }

    @Override
    public int getCount() {
        return mDataList == null ? 0 : mDataList.size();
    }

    @Override
    public T getItem(int position) {
        if (position < 0 || position >= getCount()) {
            return null;
        }
        return mDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    public void destory() {
        if (mDataList != null) {
            mDataList.clear();
        }
        mContext = null;
    }
}
