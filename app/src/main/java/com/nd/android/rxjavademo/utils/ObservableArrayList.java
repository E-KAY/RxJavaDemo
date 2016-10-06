package com.nd.android.rxjavademo.utils;

import android.database.DataSetObserver;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collection;

public class ObservableArrayList<T> extends ArrayList<T> {

    private final DataSetObserver mObserver;

    public ObservableArrayList(DataSetObserver observer) {
        mObserver = observer;
    }

    @Override
    public void add(int location, T object) {
        super.add(location, object);
        mObserver.onChanged();
    }

    @Override
    public boolean add(T object) {
        boolean result = super.add(object);
        mObserver.onChanged();
        return result;
    }

    @Override
    public boolean addAll(int location, Collection<? extends T> collection) {
        boolean result = super.addAll(location, collection);
        mObserver.onChanged();
        return result;
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        boolean result = super.addAll(collection);
        mObserver.onChanged();
        return result;
    }

    @Override
    public void clear() {
        super.clear();
        mObserver.onChanged();
    }

    @Override
    public T remove(int location) {
        T t = super.remove(location);
        mObserver.onChanged();
        return t;
    }

    @Override
    public boolean remove(Object object) {
        boolean result = super.remove(object);
        mObserver.onChanged();
        return result;
    }

    @Override
    public boolean removeAll(@NonNull Collection<?> collection) {
        boolean result = super.removeAll(collection);
        mObserver.onChanged();
        return result;
    }

    @Override
    public boolean retainAll(@NonNull Collection<?> collection) {
        boolean result = super.retainAll(collection);
        mObserver.onChanged();
        return result;
    }

    @Override
    public T set(int location, T object) {
        T t = super.set(location, object);
        mObserver.onChanged();
        return t;
    }
}
