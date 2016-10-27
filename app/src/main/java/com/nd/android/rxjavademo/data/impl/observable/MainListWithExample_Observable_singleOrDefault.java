package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import rx.Observable;
import rx.functions.Func1;

/**
 * Observable_singleDefault
 * <p>
 * Created by HuangYK on 16/10/25.
 */
public class MainListWithExample_Observable_singleOrDefault extends MainListWithExample_Observable {

    public MainListWithExample_Observable_singleOrDefault() {
        addExample(example1());
        addExample(example2());
        addExample(example3());
        addExample(example4());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_singleOrDefault_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_singleOrDefault;
    }

    private Observable example1() {
        // 要注意的是，如果这里还是返回多个数据，也是会抛异常。

        return Observable.empty().singleOrDefault(6);
    }

    private Observable example2() {

        return Observable.just(1).singleOrDefault(6);
    }

    private Observable example3() {

        return Observable.range(1, 5).singleOrDefault(10, new Func1<Integer, Boolean>() {
            @Override
            public Boolean call(Integer integer) {
                return integer == 3;
            }
        });
    }

    private Observable example4() {

        return Observable.range(1, 5).singleOrDefault(10, new Func1<Integer, Boolean>() {
            @Override
            public Boolean call(Integer integer) {
                return integer > 5;
            }
        });
    }

}


