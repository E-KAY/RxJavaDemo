package com.nd.android.rxjavademo.activity.observable;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.nd.android.rxjavademo.R;
import com.nd.android.rxjavademo.activity.BaseCompatActivity;
import com.nd.android.rxjavademo.data.IMainListWithExampleData;
import com.nd.android.rxjavademo.data.MainListDataFactory;
import com.nd.android.rxjavademo.presenter.IObservableShowExamplePresenter;
import com.nd.android.rxjavademo.presenter.impl.ObservableShowExamplePresenter;
import com.nd.android.rxjavademo.utils.MaterialDialogUtil;

import rx.Observable;

/**
 * Observable展示例子界面
 * <p>
 * Created by HuangYK on 16/10/2.
 */
public class ObservableShowExampleActivity extends BaseCompatActivity implements IObservableShowExamplePresenter.IView {

    private static final String DATA_ID = "DATA_ID";

    private IMainListWithExampleData mExampleData;

    private IObservableShowExamplePresenter mPresenter;
    private MaterialDialog mMaterialDialog;
    private String mDlgContent = "";


    public static void starActivity(@NonNull Context context, int dataId) {
        Intent intent = new Intent(context, ObservableShowExampleActivity.class);
        intent.putExtra(DATA_ID, dataId);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!getIntentData()) {
            finish();
            return;
        }
        setContentView(getContentViewId());
        initView();
        initData();
    }


    private boolean getIntentData() {
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra(DATA_ID)) {
            int dataId = intent.getIntExtra(DATA_ID, 0);
            try {
                mExampleData = (IMainListWithExampleData) MainListDataFactory.getInstance().getMainListData(dataId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return mExampleData != null;
    }

    protected int getContentViewId() {
        return R.layout.activity_observable_show_example;
    }

    protected void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        assert toolbar != null;
        toolbar.setTitle(mExampleData.getSubTitle());
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        if (mExampleData.getDetailInfo() != 0) {
            TextView tv_detail_info = (TextView) findViewById(R.id.tv_detail_info);
            if (tv_detail_info == null) {
                return;
            }
            tv_detail_info.setText(mExampleData.getDetailInfo());
            tv_detail_info.setVisibility(View.VISIBLE);
        }
        initShowExampleBtn();
    }

    protected void initData() {
        mPresenter = new ObservableShowExamplePresenter(this);
    }

    private void initShowExampleBtn() {
        if (mExampleData.getExampleSize() <= 0) {
            return;
        }

        LinearLayout ll_content = (LinearLayout) findViewById(R.id.ll_content);
        if (ll_content == null) {
            return;
        }

        for (int i = 0, length = mExampleData.getExampleSize(); i < length; i++) {
            AppCompatButton button = new AppCompatButton(this);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            int margin = getResources().getDimensionPixelSize(R.dimen.margin_example_btn);
            lp.setMargins(margin, margin, margin, margin);
            button.setLayoutParams(lp);
            button.setText(String.format(getString(R.string.str_example_format), i + 1));
            final int finalI = i;
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mPresenter.showExample(finalI);
                }
            });
            ll_content.addView(button);
        }
    }

    @Override
    public void showResultDialog(String content) {

        if (mMaterialDialog != null && mMaterialDialog.isShowing()) {
            mMaterialDialog.cancel();
        }
        mDlgContent = content + ":";
        mMaterialDialog = MaterialDialogUtil.showConfirmDialog(
                this,
                getString(mExampleData.getSubTitle()),
                content,
                null
        );
    }

    @Override
    public void cancelResultDialog() {
        if (mMaterialDialog != null && mMaterialDialog.isShowing()) {
            mMaterialDialog.cancel();
        }
    }

    @Override
    public void updateResultDialogMsg(String msg) {
        if (mMaterialDialog == null || !mMaterialDialog.isShowing()) {
            return;
        }
        mDlgContent += msg;
        mMaterialDialog.setContent(mDlgContent);
    }

    @Override
    public IMainListWithExampleData getMainListWithExampleData() {
        return mExampleData;
    }

    @Override
    public <T> Observable<T> getExample(int index) {
        return mExampleData.getExample(index);
    }

    @Override
    public <T> Observable<T> getSubjectAsObservable() {
        return mExampleData.getSubjectAsObservable();
    }

    @Override
    public int getRequest(int index) {
        return mExampleData.getRequest(index);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.destory();
        }
    }
}
