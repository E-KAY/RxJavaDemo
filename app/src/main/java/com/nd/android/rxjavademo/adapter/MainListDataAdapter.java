package com.nd.android.rxjavademo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.nd.android.rxjavademo.data.IMainListData;
import com.nd.android.rxjavademo.widget.MainListDataHeaderView;
import com.nd.android.rxjavademo.widget.MainListDataItemView;

import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;

/**
 * MainListDataAdapter
 * <p>
 * Created by HuangYK on 16/8/30.
 */
public class MainListDataAdapter extends RJDBaseAdapter<IMainListData> implements StickyListHeadersAdapter {


    public MainListDataAdapter(@NonNull Context context) {
        super(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MainListDataItemView itemView = (MainListDataItemView) convertView;
        if (itemView == null) {
            itemView = new MainListDataItemView(mContext);
        }
        itemView.setData(getItem(position));
        return itemView;
    }


    @Override
    public View getHeaderView(int position, View convertView, ViewGroup parent) {
        MainListDataHeaderView headerView = (MainListDataHeaderView) convertView;
        if (headerView == null) {
            headerView = new MainListDataHeaderView(mContext);
        }
        IMainListData data = getItem(position);
        headerView.setData(data == null ? 0 : data.getMainTitle());
        return headerView;
    }

    @Override
    public long getHeaderId(int position) {
        IMainListData data = getItem(position);
        return data == null ? 0 : data.getMainTitle();
    }
}
