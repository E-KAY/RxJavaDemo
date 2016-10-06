package com.nd.android.rxjavademo.widget;

import android.content.Context;
import android.support.annotation.StringRes;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nd.android.rxjavademo.R;

/**
 * MainListDataHeaderView
 * <p>
 * Created by HuangYK on 16/8/30.
 */
public class MainListDataHeaderView extends LinearLayout {

    private TextView mTvHeader;

    public MainListDataHeaderView(Context context) {
        super(context);
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_main_list_data_header, this, true);
        mTvHeader = (TextView) findViewById(R.id.tv_header);
        setBackgroundResource(R.color.color_gun_gray_light);
    }

    public void setData(@StringRes int headerTitleRes) {
        if (headerTitleRes == 0) {
            headerTitleRes = R.string.str_mainlist_unkonwn_header;
        }
        mTvHeader.setText(headerTitleRes);
    }

}
