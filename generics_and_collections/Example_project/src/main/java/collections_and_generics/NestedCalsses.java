package collections_and_generics;

import org.w3c.dom.Node;

import java.util.AbstractCollection;

public class NestedCalsses {

    public static void main(String[] args) {
       /* 4.3 Nested Classes
        Java permits nesting one class inside another. If the outer class has type parameters and the inner class is not static,
        then type parameters of the outer class are visible within the inner class.
        Example 4-1 shows a class implementing collections as a singly-linked list. The class extends java.util.AbstractCollection,
        ]so it only needs to define the methods size, add, and iterator. The class contains an inner class,
        Node, for the list nodes, and an anonymous inner class implementing Iterator<E >.
        The type parameter E is in scope within both of these classes.
        Example 4-1. Type parameters are in scope for nested, nonstatic classes
        public class LinkedCollection<E> extends AbstractCollection<E> { private class Node {
            private E element;
            private Node next = null;
            private Node(E elt) { element = elt; }
        }
            private Node first = new Node(null);
            private Node last = first;
            private int size = 0;
            public LinkedCollection() {}
            public LinkedCollection(Collection<? extends E> c) { addAll(c); }
            public int size() { return size; }
            public boolean add(E elt) {
            last.next = new Node(elt); last = last.next; size++;
            return true; }
            public Iterator<E> iterator() { return new Iterator<E>() {
            private Node current = first; public boolean hasNext() {
            return current.next != null; }
            public E next() {
            if (current.next != null) {
            current = current.next;
            return current.element;
            } else throw new NoSuchElementException();
            }
            public void remove() {
            throw new UnsupportedOperationException(); }
            };
            }
            }

      */

    }

}
