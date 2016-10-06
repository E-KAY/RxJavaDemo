package com.nd.android.rxjavademo.data.impl.observable;

import android.support.annotation.StringRes;

import com.nd.android.rxjavademo.R;
import com.nd.android.rxjavademo.data.IMainListData;

/**
 * MainListData_Observable
 * <p/>
 * Created by HuangYK on 16/8/30.
 */
public abstract class MainListData_Observable implements IMainListData {

    @Override
    @StringRes
    public int getMainTitle() {
        return R.string.str_mainlist_Observable;
    }
}
