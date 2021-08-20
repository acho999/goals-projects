package collections.api;

public interface ISet <T> extends Iterable<T>{

    void add(T element);
    boolean remove(T element);
    boolean contains(T element);
    boolean isEmpty();

}
