package com.nd.android.rxjavademo.activity;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.Toolbar;

import com.nd.android.rxjavademo.R;
import com.nd.android.rxjavademo.data.IMainListData;

/**
 * BaseShowActivity
 * <p/>
 * Created by HuangYK on 16/9/1.
 */
public abstract class BaseShowActivity extends BaseCompatActivity {

    protected IMainListData mMainListData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        if (!initData()) {
            finish();
            return;
        }
        initView();
        initEvent();
    }

    private boolean initData() {
        mMainListData = getMainListData();
        if (mMainListData == null) {
            return false;
        }
        _initData();
        return true;
    }

    protected void _initData() {

    }

    @SuppressWarnings("ConstantConditions")
    protected void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(mMainListData.getSubTitle());
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    protected void initEvent() {
    }

    @LayoutRes
    protected abstract int getContentViewId();

    protected abstract IMainListData getMainListData();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMainListData = null;
    }
}

