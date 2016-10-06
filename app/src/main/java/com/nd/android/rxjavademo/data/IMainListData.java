package com.nd.android.rxjavademo.data;

import android.content.Context;
import android.support.annotation.StringRes;

import java.io.Serializable;

/**
 * 主界面内容列表数据接口
 * <p/>
 * Created by HuangYK on 16/8/29.
 */
public interface IMainListData extends Serializable {

    void starActivity(Context context);

    @StringRes
    int getMainTitle();

    @StringRes
    int getSubTitle();
}
