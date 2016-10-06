package com.nd.android.rxjavademo.utils;

import java.util.List;

/**
 * utils
 * <p/>
 * Created by HuangYK on 16/8/30.
 */
public final class CommonUtils {

    public static boolean isEmptyList(List<?> list) {
        return list == null || list.isEmpty();
    }
}
