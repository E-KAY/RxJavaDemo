package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

import rx.Observable;
import rx.Scheduler;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

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
        List<String> stringList = new ArrayList<>();
        stringList.add("item1");
        stringList.add("item2");
        stringList.add("item3");
        return Observable.from(stringList);
    }

    private Observable example2() {
//        Observable observable1 = Observable.interval(300, TimeUnit.MILLISECONDS).take(5);
//        Observable observable2 = Observable.interval(400, TimeUnit.MILLISECONDS).take(5);
//        Observable observable3 = Observable.interval(500, TimeUnit.MILLISECONDS).take(5);
//        List<Observable> observables = new ArrayList<>();
//        observables.add(observable1);
//        observables.add(observable2);
//        observables.add(observable3);

        final FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "hello...";
            }
        });
        Scheduler.Worker worker = Schedulers.io().createWorker();
        worker.schedule(new Action0() {
            @Override
            public void call() {
                futureTask.run();
            }
        });

        return Observable.from(futureTask);
    }

    private Observable example3() {
        return fromCallableObservable(9);
    }

    private Observable fromCallableObservable(final int value) {

        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return value > 10;
            }
        });
    }
}
