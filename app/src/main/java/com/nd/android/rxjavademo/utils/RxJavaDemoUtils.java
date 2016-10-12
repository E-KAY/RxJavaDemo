package com.nd.android.rxjavademo.utils;

import android.util.Log;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import rx.Scheduler;
import rx.schedulers.Schedulers;

/**
 * utils
 * <p/>
 * Created by HuangYK on 16/8/30.
 */
public final class RxJavaDemoUtils {

    public static boolean isEmptyList(List<?> list) {
        return list == null || list.isEmpty();
    }

    public static Scheduler getNamedScheduler(final String name) {
        return Schedulers.from(Executors.newCachedThreadPool(new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, name);
            }
        }));
    }

    public static void threadInfo(String caller) {
        LogW(caller + " => " + Thread.currentThread().getName());
    }

    public static void LogW(String log) {
        Log.w("IM-Android", log);
    }
}
