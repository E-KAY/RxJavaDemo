package com.nd.android.rxjavademo.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nd.android.rxjavademo.R;
import com.nd.android.rxjavademo.data.IMainListData;

/**
 * MainListDataItemView
 * <p/>
 * Created by HuangYK on 16/8/30.
 */
public class MainListDataItemView extends RelativeLayout {

    private TextView mTitle;
    private IMainListData mMainListData;

    public MainListDataItemView(Context context) {
        super(context);

        initView();
        initEvent();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_main_list_data_item, this, true);
        mTitle = (TextView) findViewById(R.id.tv_title);
        setBackgroundResource(R.drawable.bg_white_ripple);
    }

    private void initEvent() {
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mMainListData == null) {
                    return;
                }
                mMainListData.starActivity(getContext());
            }
        });
    }

    public void setData(IMainListData iMainListData) {
        if (iMainListData == null) {
            throw new IllegalArgumentException("iMainListData does not allow null");
        }

        mMainListData = iMainListData;

        mTitle.setText(mMainListData.getSubTitle());
    }


}
