package com.nd.android.rxjavademo.activity.schedulers;

import com.nd.android.rxjavademo.R;
import com.nd.android.rxjavademo.activity.BaseShowActivity;
import com.nd.android.rxjavademo.data.IMainListData;
import com.nd.android.rxjavademo.data.impl.schedulers.MainListData_Schedulers;

/**
 * SubscribeOn
 * <p>
 * Created by HuangYK on 16/9/1.
 */
public class Activity_Observable_schedulers extends BaseShowActivity {

    @Override
    protected int getContentViewId() {
        return R.layout.activity_schedulers;
    }

    @Override
    protected IMainListData getMainListData() {
        return new MainListData_Schedulers();
    }
}
