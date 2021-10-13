package com.angel.generics;

import java.util.Collection;
import java.util.Objects;

public class Generics<E> {

    //    // Using a recursive type bound to express mutual comparability public static <E extends Comparable<E>> E max(Collection<E> c);
//    The type bound <E extends Comparable<E>> may be read as “any type E that can be compared to itself,” which corresponds more or less precisely to the notion of mutual comparability.
//    Here is a method to go with the previous declaration. It calculates the maximum value in a collection according to its elements’ natural order, and it compiles without errors or warnings:
//    Click here to view code image
    // Returns max value in a collection - uses recursive type bound
    public static <E extends Comparable<E>> E max(Collection<E> c) {
        if (c.isEmpty()) {
            throw new IllegalArgumentException("Empty collection");
        }
        E result = null;
        for (E e : c) {
            if (result == null || e.compareTo(result) > 0) {
                result = Objects.requireNonNull(e);
            }
        }
        return result;
    }

    public <E> E pop(){return null;}
    public <E> void push(E element){}
    public boolean isEmpty(){return true;}

    /////////////////////////////////////////
/// Wildcard type for parameter that serves as an E consumer
    public void popAll(Collection<? super E> dst) {
        while (!isEmpty()) {
            dst.add(pop());
        }
    }


    // Wildcard type for a parameter that serves as an E producer
    public void pushAll(Iterable<? extends E> src) {
        for (E e : src) {
            push(e);
        }
    }
    //PECS stands for producer-extends, consumer-super.
    //In other words, if a parameterized type represents a T producer, use <? extends T>;
    // if it represents a T consumer, use <? super T>. In our Stack example, pushAll’s src
    // parameter produces E instances for use by the Stack, so the appropriate type for src is
    // Iterable<? extends E>; popAll’s dst parameter consumes E instances from the Stack,
    // so the appropriate type for dst is Collection<? super E>.
    // The PECS mnemonic captures the fundamental principle that guides the use of wild-card types.
    // Naftalin and Wadler call it the Get and Put Principle [Naftalin07, 2.4].


//    Next let’s turn our attention to the max method in Item 30. Here is the original declaration:
//    Click here to view code image
//    public static <T extends Comparable<T>> T max(List<T> list)
//    Here is a revised declaration that uses wildcard types:
//    Click here to view code image
//    public static <T extends Comparable<? super T>> T max( List<? extends T> list)
//    To get the revised declaration from the original, we applied the PECS heuristic twice.
//    The straightforward application is to the parameter list. It produces T instances, so we change the type from List<T> to List<? extends T>. The tricky application is to the type parameter T.
//    This is the first time we’ve seen a wildcard applied to a type parameter. Originally, T was specified to extend Comparable<T>, but a comparable of T consumes T instances (and produces integers indicating order relations).
//    Therefore, the parameterized type
//    Comparable<T> is replaced by the bounded wildcard type Comparable<? super T>.
//    Comparables are always consumers, so you should generally use Comparable<? super T> in preference to Comparable<T>.
//    The same is true of comparators; therefore, you should generally use Comparator<? super T>inpreferencetoComparator<T>.
//


}


