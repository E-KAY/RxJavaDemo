package com.nd.android.rxjavademo.data.impl.schedulers;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;

import com.nd.android.rxjavademo.R;
import com.nd.android.rxjavademo.activity.schedulers.Activity_Observable_schedulers;
import com.nd.android.rxjavademo.data.IMainListData;

/**
 * MainListData_Schedulers
 * <p/>
 * Created by HuangYK on 16/8/30.
 */
public class MainListData_Schedulers implements IMainListData {

    @Override
    @StringRes
    public int getMainTitle() {
        return R.string.str_mainlist_schedulers;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_schedulers;
    }

    @Override
    public void starActivity(Context context) {
        Intent intent = new Intent(context, Activity_Observable_schedulers.class);
        context.startActivity(intent);
    }

//    @Override
//    public int compareTo(@NonNull Object another) {
//        if (!(another instanceof IMainListData)) {
//            return 1;
//        }
//        IMainListData anotherData = (IMainListData) another;
//
//        if (this.getSubTitle() > anotherData.getSubTitle()) {
//            return 1;
//        } else if (this.getSubTitle() < anotherData.getSubTitle()) {
//            return -1;
//        } else {
//            return 0;
//        }
//    }
}
