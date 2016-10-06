package com.nd.android.rxjavademo.presenter;

import com.nd.android.rxjavademo.data.IMainListWithExampleData;

import rx.Observable;

/**
 * ObservableShowExamplePresenter interface
 * <p>
 * Created by HuangYK on 16/10/2.
 */
public interface IObservableShowExamplePresenter {

    void showExample(int index);

    void cancelExample();

    void destory();

    /**
     * The interaction between the Presenter and the UI
     */
    interface IView {

        void showResultDialog(String content);

        void cancelResultDialog();

        void updateResultDialogMsg(String msg);

        IMainListWithExampleData getMainListWithExampleData();

        <T> Observable<T> getExample(int index);

        <T> Observable<T> getSubjectAsObservable();

        int getRequest(int index);
    }

}
