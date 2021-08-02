package collections.api;

public interface IStack<T> extends Iterable<T>{

    T pop();
    void push(T element);
    T peek();
    boolean isFull();
    boolean isEmpty();
    int size();

}
