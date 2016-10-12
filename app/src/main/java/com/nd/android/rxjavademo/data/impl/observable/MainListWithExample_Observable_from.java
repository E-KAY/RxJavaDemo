package com.nd.android.rxjavademo.data.impl.observable;

import android.support.annotation.NonNull;

import com.nd.android.rxjavademo.R;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import rx.Observable;

/**
 * Observable_from
 * <p/>
 * Created by HuangYK on 16/10/3.
 */
public class MainListWithExample_Observable_from extends MainListWithExample_Observable {

    public MainListWithExample_Observable_from() {
        addExample(example1());
        addExample(example2());
        addExample(example3());
        addExample(example4());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_from_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_from;
    }


    private Observable example1() {
        // from(T[] array)

        String[] strings = new String[]{"item1", "item2", "item3"};
        return Observable.from(strings);
    }

    private Observable example2() {
        // from(Iterable<? extends T> iterable)

        List<String> stringList = new ArrayList<>();
        stringList.add("item1");
        stringList.add("item2");
        stringList.add("item3");
        return Observable.from(stringList);
    }

    private Observable example3() {
        // from(Future<? extends T> future)

//        final FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
//            @Override
//            public String call() throws Exception {
//                return "hello...";
//            }
//        });
//        Scheduler.Worker worker = Schedulers.io().createWorker();
//        worker.schedule(new Action0() {
//            @Override
//            public void call() {
//                futureTask.run();
//            }
//        });
        return Observable.from(getFuture());
    }

    private Observable example4() {
        // from(Future<? extends T> future, long timeout, TimeUnit unit)

        return Observable.from(getFuture(), 500, TimeUnit.MILLISECONDS);
    }

    private Future getFuture() {

        return new Future<String>() {
            @Override
            public boolean cancel(boolean mayInterruptIfRunning) {
                return false;
            }

            @Override
            public boolean isCancelled() {
                return false;
            }

            @Override
            public boolean isDone() {
                return false;
            }

            @Override
            public String get() throws InterruptedException, ExecutionException {
                return "Future.get()";
            }

            @Override
            public String get(long timeout, @NonNull TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
                // 如果在 timeout 限定内没有返回内容，则会调用的 Observable 会发送onError通知，然后终止。
                return "Future.get(timeout:" + timeout + ", unit:" + unit + ")";
            }
        };
    }
}
