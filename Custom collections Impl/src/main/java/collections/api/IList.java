package collections.api;

import java.util.Arrays;

public interface IList<T> extends Iterable<T>{

    //void increseCapacity();
    void add(T element);
    void clear();
    T get(int index);
    Object remove(int index);
    int size();
    int numberOfElements();
    boolean isEmpty();
    boolean contains(T element);
    void insert(int index, T element);

    default T[] increseCapacity(T[] elements) {
        int doubledCapacity = elements.length * 2;//double count of elements
        elements =
            Arrays.copyOf(elements, doubledCapacity);//copy old array in new with new capacity
        System.out.println(elements.length);
        return elements;
    }

}
