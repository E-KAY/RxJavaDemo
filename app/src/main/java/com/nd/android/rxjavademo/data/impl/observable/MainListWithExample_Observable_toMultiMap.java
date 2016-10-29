package com.nd.android.rxjavademo.data.impl.observable;

import com.nd.android.rxjavademo.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import rx.Observable;
import rx.functions.Func0;
import rx.functions.Func1;

/**
 * Observable_toMultiMap
 * <p>
 * Created by HuangYK on 16/10/27.
 */
public class MainListWithExample_Observable_toMultiMap extends MainListWithExample_Observable {

    public MainListWithExample_Observable_toMultiMap() {
        addExample(example1());
        addExample(example2());
        addExample(example3());
        addExample(example4());
    }

    @Override
    public int getDetailInfo() {
        return R.string.str_mainlist_Observable_toMultiMap_info;
    }

    @Override
    public int getSubTitle() {
        return R.string.str_mainlist_Observable_toMultiMap;
    }

    private Observable example1() {
        return Observable.range(1, 10).toMultimap(new Func1<Integer, String>() {
            @Override
            public String call(Integer integer) {
                return integer % 2 == 0 ? "even" : "odd";
            }
        });
    }

    private Observable example2() {
        return Observable.range(1, 10).toMultimap(new Func1<Integer, String>() {
            @Override
            public String call(Integer integer) {
                return integer % 2 == 0 ? "even" : "odd";
            }
        }, new Func1<Integer, String>() {
            @Override
            public String call(Integer integer) {
                return "" + integer;
            }
        });
    }

    private Observable example3() {
        return Observable.range(1, 10).toMultimap(
                new Func1<Integer, String>() {
                    @Override
                    public String call(Integer integer) {
                        return integer % 2 == 0 ? "even" : "odd";
                    }
                }, new Func1<Integer, String>() {
                    @Override
                    public String call(Integer integer) {
                        return "" + integer;
                    }
                }, new Func0<Map<String, Collection<String>>>() {
                    @Override
                    public Map<String, Collection<String>> call() {
                        return new HashMap<>();
                    }
                });
    }

    private Observable example4() {

        final String KEY_EVEN = "even";
        final String KEY_ODD = "odd";

        return Observable.range(1, 10).toMultimap(
                new Func1<Integer, String>() {
                    @Override
                    public String call(Integer integer) {
                        return integer % 2 == 0 ? KEY_EVEN : KEY_ODD;
                    }
                }, new Func1<Integer, String>() {
                    @Override
                    public String call(Integer integer) {
                        return "" + integer;
                    }
                }, new Func0<Map<String, Collection<String>>>() {
                    @Override
                    public Map<String, Collection<String>> call() {
                        return new HashMap<>();
                    }
                }, new Func1<String, Collection<String>>() {
                    @Override
                    public Collection<String> call(final String s) {
                        // 不把 key 加到 value 列表里
                        if (KEY_EVEN.equals(s) || KEY_ODD.equals(s)) {
                            return new ArrayList<>();
                        }
                        return new ArrayList<String>() {{
                            add(s);
                        }};
                    }
                });
    }

}
