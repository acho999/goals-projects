package collections.impl;

public class CustomStack<T> {

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

    public int size(){
        return this.elements.length;
    }

    public boolean isEmpty(){
        return this.top == -1;
    }

    public boolean isFull(){
        return this.top == capacity-1;
    }

    public void push(T value){
        if (this.isFull()){
            throw new StackFullException("Stack is full!");
        }
        this.elements[++top] = value;
    }

    public T pop(){
        if (this.isEmpty()){
            throw new StackEmptyException("Stack is empty!");
        }
        return this.elements[top--];
    }

    public T peek(){
        return this.elements[top];
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