package collections_and_generics;

import java.util.ArrayList;
import java.util.List;

public class SubtypingAndWildcards {

    public static void main(String[] args) {
        /*
        Integer is subtype of Number
        Double is subtype of Number
        ArrayList<T> is subtype of List<T>
        List<T> is subtype of Collection<T>
        Collection<T> is subtype of Iterable<T>

        The Substitution Principle tells us that wherever a value of one type is expected,
        one may provide a value of any subtype of that type:
        Substitution Principle: a variable of a given type may be assigned a value of any subtype of that type,
        and a method with a parameter of a given type may be invoked with an argument of any subtype of that type.
        */
        /*According to the Substitution Principle, if we have a collection of numbers,
        we may add an integer or a double to it, because Integer and Double are subtypes of Number.
           */
        List<Number> nums = new ArrayList<Number>(); nums.add(2);
        nums.add(3.14);
        assert nums.toString().equals("[2, 3.14]");

        /*
            List<Integer> ints = new ArrayList<Integer>(); ints.add(1);
            ints.add(2);
            List<Number> nums = ints; // compile-time error nums.add(3.14);
            assert ints.toString().equals("[1, 2, 3.14]"); // uh oh!
            Substitution Principle does not apply: the assignment on the fourth line is not allowed
            because List<Integer> is not a subtype of List<Number>,
            and the compiler reports that the fourth line is in error.

            What about the reverse? Can we take List<Number> to be a subtype of List<Integer>?
            No, that doesn’t work either, as shown by the following code:
            List<Number> nums = new ArrayList<Number>(); nums.add(2.78);
            nums.add(3.14);
            List<Integer> ints = nums; // compile-time error
            assert ints.toString().equals("[2.78, 3.14]"); // uh oh!
        */

        /*
        Clearly, given a collection of elements of type E, it is OK to add all members of another collection with elements of type E. The quizzical phrase "? extends E" means that it is also OK to add all members of a collection with elements of any type that is a subtype of E. The question mark is called a wildcard, since it stands for some type that is a subtype of E.
        Here is an example. We create an empty list of numbers, and add to it first a list of integers and then a list of doubles:
        List<Number> nums = new ArrayList<Number>();
        List<Integer> ints = Arrays.asList(1, 2);
        List<Double> dbls = Arrays.asList(2.78, 3.14);
        nums.addAll(ints);
        nums.addAll(dbls);
        assert nums.toString().equals("[1, 2, 2.78, 3.14]");
        The first call is permitted because nums has type List<Number>,
        which is a subtype of Collection<Number>, and ints has type List<Integer>,
        which is a subtype of Collec tion<? extends Number>.
        The second call is similarly permitted.In both calls, E is taken to be Number.
        If the method signature for addAll had been written without the wildcard,
        then the calls to add lists of integers and doubles to a list of numbers would not have been permitted;
        \you would only have been able to add a list that was explicitly declared to be a list of numbers.

        We can also use wildcards when declaring variables.
        Here is a variant of the example at the end of the preceding section,
        changed by adding a wildcard to the second line:
        List<Integer> ints = new ArrayList<Integer>(); ints.add(1);
        ints.add(2);
        List<? extends Number> nums = ints; nums.add(3.14); // compile-time error
        assert ints.toString().equals("[1, 2, 3.14]"); // uh oh!

        Here is a method that copies into a destination list all of the elements from a source list, from the convenience class Collections:
        public static <T> void copy(List<? super T> dst, List<? extends T> src) {
        for (int i = 0; i < src.size(); i++) {
        dst.set(i, src.get(i)); }
        }
        The quizzical phrase ? super T means that the destination
        list may have elements of any type that is a supertype of T,
        just as the source list may have elements of any type that is a subtype of T.
        Here is a sample call.
        List<Object> objs = Arrays.<Object>asList(2, 3.14, "four");
        List<Integer> ints = Arrays.asList(5, 6);
        Collections.copy(objs, ints);
        assert objs.toString().equals("[5, 6, four]");

        Collections.copy(objs, ints);
        Collections.<Object>copy(objs, ints);
        Collections.<Number>copy(objs, ints);
        Collections.<Integer>copy(objs, ints);
        The first call leaves the type parameter implicit; it is taken to be Integer,
        since that is the most specific choice that works. In the third line,
        the type parameter T is taken to be Number. The call is permitted because objs has type List<Object>,
        which is a subtype of List<? super Number> (since Object is a supertype of Number,
        as required by the wildcard) and ints has type List<Integer>,
        which is a subtype of List<? extends Num ber> (since Integer is a subtype of Number, as required by the extends wildcard).
        We could also declare the method with several possible signatures.
        public static <T> void copy(List<T> dst, List<T> src)
        public static <T> void copy(List<T> dst, List<? extends T> src)
        public static <T> void copy(List<? super T> dst, List<T> src)
        public static <T> void copy(List<? super T> dst, List<? extends T> src)
        The first of these is too restrictive, as it only permits calls when the
        destination and source have exactly the same type. The remaining three are equivalent for
        calls that use implicit type parameters, but differ for explicit type parameters.
        For the example calls above, the second signature works only when the type parameter is Object,
        the third signature works only when the type parameter is Integer,
        and the last signature works (as we have seen) for all three type parameters—i.e., Object, Number, and Integer.
        Al- ways use wildcards where you can in a signature, since this permits the widest range of calls.


        */

        /*
        * The Get and Put Principle
        It may be good practice to insert wildcards whenever possible,
        but how do you decide which wildcard to use? Where should you use extends, where should you use super,
        and where is it inappropriate to use a wildcard at all?
        Fortunately, a simple principle determines which is appropriate.
        The Get and Put Principle: use an extends wildcard when you only get values out of a structure,
        use a super wildcard when you only put values into a structure, and don’t use a wildcard when you both get and put.
        We already saw this principle at work in the signature of the copy method:
        public static <T> void copy(List<? super T> dest, List<? extends T> src)
        The method gets values out of the source src, so it is declared with an extends wildcard,
        and it puts values into the destination dst, so it is declared with a super wildcard.
        *
        * Whenever you both put values into and get values out of the same structure, you should
        not use a wildcard.
        public static double sumCount(Collection<Number> nums, int n) { count(nums, n);
        return sum(nums);
        * }
        *You cannot put anything into a type declared with an extends wildcard—except for the value null,
        *  which belongs to every reference type
        *
        You may find it helpful to think of ? extends T as containing every type in an interval
        * bounded by the type of null below and by T above (where the type of null is a subtype ofeveryreferencetype).
        * Similarly,youmaythinkof? super Tascontainingeverytype in an interval bounded by T below and by Object above.
       */

    }

}
