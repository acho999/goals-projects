package collections.impl;

import collections.api.IList;

import java.util.Arrays;
import java.util.Iterator;

public class CustomArrayList<T extends Comparable<T>> implements IList<T> {

    private static final int INITIAL_CAPACITY = 10;
    public T[] elements;
    private int size;
    private int length;

    public CustomArrayList() {
        this.elements = (T[]) new Comparable[INITIAL_CAPACITY];
        this.length = INITIAL_CAPACITY;
        this.size = 0;
    }

    @Override
    public void add(
        T element) {//complexity O(n) because when it is full it is need restructoring with doubling size
        //and O(1) if it is not need restructoring when it is not full
        if (this.size == this.length) {//check if count of elements is equal to array length
            this.elements = increseCapacity(this.elements);
            this.length = this.elements.length;
        }
        this.elements[this.size++] = element;
    }

    @Override
    public T get(int index) {//O(1) because we have one constant operation
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size "
                                                + index);
        }
        return (T) this.elements[index];
    }

    @Override
    public Object remove(
        int index) {//complexity O(n) because when it is full it is need restructoring with rearrange the array
        //and O(1) if it is not need restructoring when element is last
        if (index < 0 || index > this.size) {//check for index out of range
            throw new IndexOutOfBoundsException("Index: " + index + ", Size "
                                                + index);
        }

        Object removedElement = this.elements[index];
        for (int i = index; i < this.length - 1; i++) {

            elements[i] = elements[i + 1];//here we rearange the array from index to end

        }
        this.size--;//decrese count of elements
        return removedElement;
    }

    @Override
    public int size() {
        return this.length;
    }

    @Override
    public int numberOfElements() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean contains(T element) {
        for (int i = 0; i < this.size; i++) {
            if (this.elements[i].compareTo(element) == 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void insert(int index, T element) {
        this.size++;

        if (this.size == this.length) {
            this.elements = increseCapacity(this.elements);
            this.length = this.elements.length;
        }
        System.out.println(this.elements.length);

        T next = this.elements[index];
        T previous;
        this.elements[index] = element;

        for (int i = index; i < this.size - 1; i++) {
            previous = this.elements[i + 1];
            this.elements[i + 1] = next;
            next = previous;
        }

    }

    @Override
    public String toString() {//O(n) because we iterate over n elements
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < size; i++) {
            if (size - 1 == i) {
                str.append(elements[i].toString());
                break;
            }
            str.append(elements[i] + " ");
        }
        return str.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return Arrays.stream(this.elements).iterator();
    }

}
