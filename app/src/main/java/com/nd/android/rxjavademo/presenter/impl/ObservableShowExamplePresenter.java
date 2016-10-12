package com.nd.android.rxjavademo.presenter.impl;

import android.support.annotation.NonNull;

import com.nd.android.rxjavademo.presenter.IObservableShowExamplePresenter;
import com.nd.android.rxjavademo.utils.RxJavaDemoUtils;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Observable例子展示操作类
 * <p>
 * Created by HuangYK on 16/10/2.
 */
public class ObservableShowExamplePresenter<T> implements IObservableShowExamplePresenter {

    private IView mView;

    private CompositeSubscription mSubjectSub;

    private Subscription mExampleSub;

    public ObservableShowExamplePresenter(@NonNull IView iView) {
        mView = iView;

        Observable<T> observable = mView.getSubjectAsObservable();
        if (observable != null) {
            mSubjectSub = new CompositeSubscription();
            mSubjectSub.add(
                    observable
                            .compose(this.<T>applySchedulers())
                            .subscribe(getSubscriber())
            );
        }
    }


    @Override
    public void showExample(int index) {
        cancelExample();

        int request = mView.getRequest(index);

        RequestSubscriber requestSubscriber = null;
        if (request != 0) {
            requestSubscriber = new RequestSubscriber();
            requestSubscriber.requestMore(request);
        }

        Observable<T> observable = mView.getExample(index);
        if (observable == null) {
            return;
        }
        mView.showResultDialog("Example" + (index + 1));

        if (mSubjectSub == null) {
            mExampleSub =
                    observable
                            .compose(this.<T>applySchedulers())
                            .subscribe(requestSubscriber == null ? this.<T>getSubscriber() : requestSubscriber);
        } else {
            mExampleSub =
                    observable
                            .compose(this.<T>applySchedulers())
                            .subscribe();
        }
    }

    @Override
    public void cancelExample() {
        Thread.interrupted();
        if (mExampleSub != null) {
            mExampleSub.unsubscribe();
        }
    }

    @Override
    public void destory() {
        cancelExample();
        if (mSubjectSub != null) {
            mSubjectSub.unsubscribe();
        }
    }

    private Subscriber<T> getSubscriber() {
        return new Subscriber<T>() {
            @Override
            public void onCompleted() {
                mView.updateResultDialogMsg("\nonCompleted");
            }

            @Override
            public void onError(Throwable e) {
                mView.updateResultDialogMsg("\nonError:" + e.toString());
            }

            @SuppressWarnings("unchecked")
            @Override
            public void onNext(T result) {
                RxJavaDemoUtils.threadInfo(".onNext");
                if (result instanceof Observable) {
                    Observable observable = (Observable) result;
                    observable.compose(applySchedulers()).subscribe(getSubscriber());
                } else {
                    mView.updateResultDialogMsg("\n" + result);
                }
            }
        };
    }

    private Observable.Transformer<T, T> applySchedulers() {
        return new Observable.Transformer<T, T>() {
            @Override
            public Observable<T> call(Observable<T> tObservable) {
                return tObservable
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    private class RequestSubscriber extends Subscriber<T> {

        @Override
        public void onCompleted() {
            mView.updateResultDialogMsg("\nonCompleted");
        }

        @Override
        public void onError(Throwable e) {
            mView.updateResultDialogMsg("\nonError");
        }

        @SuppressWarnings("unchecked")
        @Override
        public void onNext(T result) {
            if (result instanceof Observable) {
                Observable observable = (Observable) result;
                observable.subscribe(getSubscriber());
            } else {
                mView.updateResultDialogMsg("\n" + result);
            }
        }

        public void requestMore(int n) {
            request(n);
        }
    }
}
