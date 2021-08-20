package collections.impl;

import collections.api.IQueue;

import java.util.Arrays;
import java.util.Iterator;

public class CustomQueue<T> implements IQueue<T> {

    private T[] elements;
    private int capacity;
    private int top;
    private int front;
    private int count;

    public CustomQueue(int capacity){

        this.capacity = capacity;
        this.elements = (T[]) new Object[capacity];
        this.top=0;
        this.count = 0;
        this.front = 0;
    }

    public CustomQueue(){
        this(16);
    }

    @Override
    public void add(T value){
        if(isFull()){
            throw new CustomQueueFullException("Queue is full!");
        }
        if(top == capacity){
            top = 0;
        }
        this.elements[top++] = value;
        this.count++;
    }

    @Override
    public T remove(){
        if(isEmpty()){
            throw new CustomQueueEmptyException("Queue is empty");
        }
        if(front == capacity){
            front = 0;
        }
        count--;
        return this.elements[this.front++];
    }
    
    @Override
    public int elementsCount(){
        return this.count;
    }

    @Override
    public boolean isEmpty(){
        return this.count == 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean isFull(){
        return this.count == capacity;
    }

    @Override
    public Iterator<T> iterator() {
        return Arrays.stream(this.elements).iterator();
    }
}

class CustomQueueFullException extends RuntimeException{

    public CustomQueueFullException(String message){
        super(message);
    }

    public CustomQueueFullException(){
        super();
    }
}

class CustomQueueEmptyException extends RuntimeException{

    public CustomQueueEmptyException(String message){
        super(message);
    }

    public CustomQueueEmptyException(){
        super();
    }

}
