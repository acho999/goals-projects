package com.angel.avoidUnnecessaryObjects;

import java.util.EmptyStackException;

public class UnnecessaryObjects {

    String s = new String("bikini"); // DON'T DO THIS!
    String str = "bikini";
/////////////////////////////////////////////////

// Hideously slow! Can you spot the object creation?
    private static long sum() {
        Long sum = 0L;//here we create wrapper Long object and that makes the program very slow
        for (long i = 0; i <= Integer.MAX_VALUE; i++)
            sum += i;
        return sum;
    }//prefer primitives to boxed primitives(wrapper classes), and watch out for unintentional autoboxing.

///////////////////////////////////
//null out references once they become obsolete.
// //In the case of our Stack class, the reference to an item becomes obsolete as soon as it’s popped off the stack.
// The corrected version of the pop method looks like this:
   int size = 0;
    Integer [] elements = {};
    public Object pop() {
        if (size == 0)
            throw new EmptyStackException();
        Object result = elements[--size];
        elements[size] = null; // Eliminate obsolete reference return result;
        return  result;
        //The best way to eliminate an obsolete reference is to let the variable that contained the reference fall out of scope.
        // This occurs naturally if you define each variable in the narrowest possible scope
    }
}
