package collections.impl;

import collections.api.ISet;
import java.util.Iterator;

public class CustomHashSet <T> implements ISet<T> {

    private CustomHashMap<T, Object> elements;

    public CustomHashSet() {
        this.elements = new CustomHashMap<>();
    }

    @Override
    public void add(T element) {

        this.elements.put(element, null);
    }

    @Override
    public boolean remove(T element) {

        return this.elements.remove(element);
    }

    @Override
    public boolean contains(T element) {

        return this.elements.containsKey(element);
    }

    @Override
    public boolean isEmpty() {

        return this.elements.isEmpty();
    }

    @Override
    public Iterator<T> iterator() {

        return (Iterator<T>) this.elements.iterator();
    }
}
