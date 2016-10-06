package com.nd.android.rxjavademo.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.nd.android.rxjavademo.R;

/**
 * MaterialDialog工具类
 * <p/>
 * Created by HuangYK on 16/8/30.
 */
public final class MaterialDialogUtil {


    public static MaterialDialog showConfirmDialog(Context context, @StringRes int title, @StringRes int msg,
                                                   final DialogInterface.OnCancelListener listener) {

        return new MaterialDialog.Builder(context)
                .title(title)
                .content(msg)
                .positiveText(R.string.str_ok)
//                .positiveColorRes(R.color.color_blue)
//                .negativeText(R.string.str_cancel)
                .negativeText("")
//                .negativeColorRes(R.color.color_red)
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        dialog.cancel();
                    }
                })
                .onNegative(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction dialogAction) {
                        dialog.cancel();
                    }
                })
                .cancelListener(listener)
                .show();
    }

    public static MaterialDialog showConfirmDialog(Context context, String title, String msg,
                                                   final DialogInterface.OnCancelListener listener) {

        return new MaterialDialog.Builder(context)
                .title(title)
                .content(msg)
                .positiveText(R.string.str_ok)
//                .positiveColorRes(R.color.color_blue)
//                .negativeText(R.string.str_cancel)
                .negativeText("")
//                .negativeColorRes(R.color.color_red)
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        dialog.cancel();
                    }
                })
                .onNegative(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction dialogAction) {
                        dialog.cancel();
                    }
                })
                .cancelListener(listener)
                .show();
    }
}
