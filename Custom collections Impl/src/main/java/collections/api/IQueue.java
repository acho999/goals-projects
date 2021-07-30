package collections.api;

public interface IQueue<T> extends Iterable<T>{

    void add(T value);
    T remove();
    boolean isFull();
    boolean isEmpty();
    int elementsCount();

}
