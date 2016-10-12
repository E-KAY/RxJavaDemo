package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import rx.Observable;
import rx.Subscriber;

/**
 * Observable_lift
 * <p>
 * Created by HuangYK on 16/10/3.
 */
public class MainListWithExample_Observable_lift extends MainListWithExample_Observable {

    public MainListWithExample_Observable_lift() {
        addExample(example1());
        addExample(example2());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_lift_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_lift;
    }

    private Observable example1() {
        return Observable.range(1, 10).lift(new Observable.Operator<Integer, Integer>() {
            @Override
            public Subscriber<? super Integer> call(final Subscriber<? super Integer> subscriber) {
                return new Subscriber<Integer>() {
                    @Override
                    public void onCompleted() {
                        if (!subscriber.isUnsubscribed()) {
                            subscriber.onCompleted();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (!subscriber.isUnsubscribed()) {
                            subscriber.onError(e);
                        }
                    }

                    @Override
                    public void onNext(Integer integer) {
                        if (!subscriber.isUnsubscribed()) {
                            subscriber.onNext(integer * 10);
                        }
                    }
                };
            }
        });
    }

    private Observable example2() {
        return Observable.range(1, 10).lift(new LiftOperator());
    }

    private class LiftOperator implements Observable.Operator<String, Integer> {

        public LiftOperator( /* any necessary params here */) {
            /* 这里添加必要的初始化代码 */
        }

        @Override
        public Subscriber<? super Integer> call(final Subscriber<? super String> subscriber) {

            return new Subscriber<Integer>(subscriber) {
                @Override
                public void onCompleted() {
                    //  这里添加你自己的onCompleted行为，或者仅仅传递完成通知
                    if (!subscriber.isUnsubscribed()) {
                        subscriber.onCompleted();
                    }
                }

                @Override
                public void onError(Throwable t) {
                    // 这里添加你自己的onError行为, 或者仅仅传递错误通知
                    if (!subscriber.isUnsubscribed()) {
                        subscriber.onError(t);
                    }
                }

                @Override
                public void onNext(Integer t) {
                    // 这里可以对每一项结果执行自己的逻辑操作
                    if (!subscriber.isUnsubscribed()) {
                        subscriber.onNext("onNext" + t);
                    }
                }
            };
        }
    }
}
