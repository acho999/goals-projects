package collections.api;

public interface IStack<T> extends Iterable<T>{

    T pop();
    void push(T element);
    T peek();

}
