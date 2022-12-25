package collections_and_generics;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class BoxingAndUnboxing {

    public static void main(String[] args) {
        //Here is how the same code looks in Java before generics:
        List ints = Arrays.asList(new Integer[] {
            new Integer(1), new Integer(2), new Integer(3)
        } );
        int s = 0;
        for (Iterator it = ints.iterator(); it.hasNext(); ) {//iterator using
            int n = ((Integer)it.next()).intValue();
            s += n;
        }
        assert s == 6;//assertion!!!
    }

    //In Java before generics, the same code would be written as follows:

    /*List words = new ArrayList();
    words.add("Hello ");
    words.add("world!");
    String s = ((String)words.get(0))+((String)words.get(1));
    assert s.equals("Hello world!");*/

    /*In fact, the bytecode compiled from the two sources above will be identical.
     We say that generics are implemented by erasure because the types List<Integer>,
     List<String>, and List<List<String>> are all represented at run-time by the same type, List.
     We also use erasure to describe the process that converts the first program to the second.
     The term erasure is a slight misnomer, since the process erases type parameters but adds casts.
    Generics implicitly perform the same cast that is explicitly performed without generics.
     If such casts could fail, it might be hard to debug code written with generics.
*/

/*
    Recall that every type in Java is either a reference type or a primitive type.
    A reference type is any class, interface, or array type.
    All reference types are subtypes of class Object,
    and any variable of reference type may be set to the value null.
*/

    /*Conversion of a primitive type to the corresponding reference type is called boxing and
    conversion of the reference type to the corresponding primitive type is called unboxing.
    Java with generics automatically inserts boxing and unboxing coercions where appro- priate.
    If an expression e of type int appears where a value of type Integer is expected, boxing converts
    it to new Integer(e) (however, it may cache frequently occurring val- ues).
    If an expression e of type Integer appears where a value of type int is expected,
    unboxing converts it to the expression e.intValue(). For example, the sequence:
    */
   // List<Integer> ints = new ArrayList<Integer>(); ints.add(1);
    //int n = ints.get(0);
    //is equivalent to the sequence:
    //List<Integer> ints = new ArrayList<Integer>(); ints.add(Integer.valueOf(1));
    //int n = ints.get(0).intValue();
//    The call Integer.valueOf(1) is similar in effect to the expression new Integer(1), but may cache some values for improved performance, as we explain shortly.
//    Here, again, is the code to find the sum of a list of integers, conveniently packaged as a static method:
    public static int sum (List<Integer> ints) { int s = 0;
        for (int n : ints) { s += n; }
        return s;
    }
/*
//    Why does the argument have type List<Integer> and not List<int>?
Because type parameters must always be bound to reference types, not primitive types.
Why does the result have type int and not Integer? Because result types may be either primitive
//1.2 Boxing and Unboxing
//
//    or reference types, and it is more efficient to use the former than the latter.
Unboxing occurs when each Integer in the list ints is bound to the variable n of type int.
*/

}
