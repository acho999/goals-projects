package collections.api;

public interface ISet <T> extends Iterable<T>{

    void add(T element);
    T remove(T element);
    boolean contains(T element);
    boolean isEmpty();

}
