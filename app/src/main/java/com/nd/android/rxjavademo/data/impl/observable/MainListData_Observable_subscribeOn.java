package com.nd.android.rxjavademo.data.impl.observable;

import android.content.Context;

import com.nd.android.rxjavademo.R;

/**
 * MainListData_Observable_subscribeOn
 * <p/>
 * Created by HuangYK on 16/8/30.
 */
public class MainListData_Observable_subscribeOn extends MainListData_Observable {

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_subscribeOn;
    }

    public void starActivity(Context context) {
//        Intent intent = new Intent(context, ObservableSubscribeActivity.class);
//        context.startActivity(intent);
    }
}
