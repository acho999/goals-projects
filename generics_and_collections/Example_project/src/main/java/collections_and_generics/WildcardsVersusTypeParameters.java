package collections_and_generics;

import java.util.Arrays;
import java.util.List;

public class WildcardsVersusTypeParameters {

    public static void main(String[] args) {
        /*Wildcards Here are the types that the methods have in Java with generics:
        interface Collection<E> { ...
            public boolean contains(Object o);
            public boolean containsAll(Collection<?> c); ...
        }
        The first method does not use generics at all! The second method is our first sight of an important abbreviation. The type Collection<?> stands for:
        Collection<? extends Object>
        Extending Object is one of the most common uses of wildcards, so it makes sense to
        provide a short form for writing it.
        These methods let us test for membership and containment:
        Object obj = "one";
        List<Object>
            objs = Arrays.<Object>asList("one", 2, 3.14, 4); List<Integer> ints = Arrays.asList(2, 4);
        assert objs.contains(obj);
        assert objs.containsAll(ints);
        assert !ints.contains(obj);
        assert !ints.containsAll(objs);
        The given list of objects contains both the string "one" and the given list of integers, but the given list of integers does not contain the string "one", nor does it contain the given list of objects.
        The tests ints.contains(obj) and ints.containsAll(objs) might seem silly. Of course, a list of integers won’t contain an arbitrary object, such as the string "one". But it is permitted because sometimes such tests might succeed:
        2.6 Wildcards Versus Type Parameters | 25

        Object obj = 1;
        List<Object> objs = Arrays.<Object>asList(1, 3); List<Integer> ints = Arrays.asList(1, 2, 3, 4); assert ints.contains(obj);
        assert ints.containsAll(objs);
        In this case, the object may be contained in the list of integers because it happens to be an integer, and the list of objects may be contained within the list of integers because every object in the list happens to be an integer.
            Type Parameters You might reasonably choose an alternative design for collections —a design in which you can only test containment for subtypes of the element type:
        interface MyCollection<E> { // alternative design ...
            public boolean contains(E o);
            public boolean containsAll(Collection<? extends E> c); ...
        }
        Say we have a class MyList that implements MyCollection. Now the tests are legal only
        one way around:
        Object obj = "one";
        MyList<Object> objs = MyList.<Object>asList("one", 2, 3.14, 4); MyList<Integer> ints = MyList.asList(2, 4);
        assert objs.contains(obj);
        assert objs.containsAll(ints)
        assert !ints.contains(obj); // compile-time error assert !ints.containsAll(objs); // compile-time error
        The last two tests are illegal, because the type declarations require that we can only test whether a list contains an element of a subtype of that list. So we can check whether a list of objects contains a list of integers, but not the other way around.
   */
    }

}
