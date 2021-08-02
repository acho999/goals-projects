package collections.impl;
import collections.api.IStack;
import java.util.Arrays;
import java.util.Iterator;

public class CustomStack<T> implements IStack<T> {

    private T[] elements;
    private int top;
    private int capacity;

    public CustomStack(int capacity) {
        this.capacity = capacity;
        this.elements = (T[])new Object[this.capacity];
        this.top = -1;
    }

    public CustomStack() {
        this(16);
    }

    @Override
    public int size(){
        return this.elements.length;
    }

    @Override
    public boolean isEmpty(){
        return this.top == -1;
    }

    @Override
    public boolean isFull(){
        return this.top == capacity-1;
    }

    @Override
    public void push(T value){
        if (this.isFull()){
            throw new StackFullException("Stack is full!");
        }
        this.elements[++top] = value;
    }

    @Override
    public T pop(){
        if (this.isEmpty()){
            throw new StackEmptyException("Stack is empty!");
        }
        return this.elements[top--];
    }

    @Override
    public T peek(){
        return this.elements[top];
    }


    @Override
    public Iterator<T> iterator() {
        return Arrays.stream(this.elements).iterator();
    }
}

class StackFullException extends RuntimeException {

    public StackFullException(String message) {
        super(message);
    }

    public StackFullException() {
        super();
    }

}

class StackEmptyException extends RuntimeException {

    public StackEmptyException(String message) {
        super(message);
    }

    public StackEmptyException() {
        super();
    }

}