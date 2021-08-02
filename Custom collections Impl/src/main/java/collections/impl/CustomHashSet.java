package collections.impl;

import collections.api.ISet;

import java.util.Iterator;

public class CustomHashSet <T> implements ISet<T> {

    

    @Override
    public void add(T element) {

    }

    @Override
    public T remove(T element) {
        return null;
    }

    @Override
    public boolean contains(T element) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
