package collections;

public class CustomQueue<T> {

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

    public int elementsCount(){
        return this.count;
    }

    public boolean isEmpty(){
        return this.count == 0;
    }

    public boolean isFull(){
        return this.count == capacity;
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
