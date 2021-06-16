package collections;

import java.util.Arrays;

public class CustomArrayList<T> {

    private static final int INITIAL_CAPACITY = 10;
    private Object [] elements = {};
    private int size= 0;

    public CustomArrayList(){
        this.elements = new Object[INITIAL_CAPACITY];
    }

    public void increseCapacity(){
        int doubledCapacity = this.elements.length * 2;//double count of elements
        this.elements = Arrays.copyOf(this.elements,doubledCapacity);//copy old array in new with new capacity
    }

    public void add(T element){//complexity O(n) because when it is full it is need restructoring with doubling size
        //and O(1) if it is not need restructoring when it is not full
        if(this.size == this.elements.length){//check if count of elements is equal to array length
            increseCapacity();
        }
        this.elements[this.size++] = element;
    }

    public T get(int index){//O(1) because we have one constant operation
        if(index < 0 || index > this.size){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size "
                                                + index);
        }
        return (T)this.elements[index];
    }

    public Object remove(int index){//complexity O(n) because when it is full it is need restructoring with rearrange the array
        //and O(1) if it is not need restructoring when element is last
        if(index < 0 || index > this.size){//check for index out of range
            throw new IndexOutOfBoundsException("Index: " + index + ", Size "
                                                + index);
        }

        Object removedElement = this.elements[index];
        for (int i = index; i < elements.length - 1; i++){

            elements[i] = elements[i+1];//here we rearange the array from index to end

        }
        this.size--;//decrese count of elements
        return removedElement;
    }

    @Override
    public String toString(){//O(n) because we iterate over n elements
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < size; i++){
            if(size-1 == i){
                str.append(elements[i].toString());
                break;
            }
             str.append(elements[i] + " ");
        }
        return str.toString();
    }

}
