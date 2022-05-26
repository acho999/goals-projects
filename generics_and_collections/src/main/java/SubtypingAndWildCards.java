import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SubtypingAndWildCards {

    public static void main(String[] args) {

//        Substitution Principle:a variable of a given type may be assigned a value of any subtype
//        of that type, and a method with a parameter of a given type may be invoked with an
//        argument of any subtype of that type.

        List<Number> nums = new ArrayList<Number>(); nums.add(2);
        nums.add(3.14);
        assert nums.toString().equals("[2, 3.14]");//that is because Integer and Double are subtypes of Number

        List<Integer> ints = new ArrayList<Integer>(); ints.add(1);
        ints.add(2);
        //List<Number> numbers = ints; // compile-time error nums.add(3.14);
        assert ints.toString().equals("[1, 2, 3.14]"); // uh oh!
//        Substitution Principle does not apply:
//        the assignment on the fourth line is not allowed because List<Integer> is not a subtype of
//        List<Number>,and the compiler reports that the fourth line is in error.

        //WILDCARDS WITH EXTENDS

        List<Number> num = new ArrayList<Number>();
        List<Integer> intss = Arrays.asList(1, 2);
        List<Double> dbls = Arrays.asList(2.78, 3.14);
        num.addAll(intss);
        num.addAll(dbls);
        assert num.toString().equals("[1, 2, 2.78, 3.14]");
//        The first call is permitted because nums has type List<Number >, which is a subtype of
//        Collection<Number>,and ints has type List<Integer>,which is a subtype of Collec
//        tion<? extends Number>.Thesecondcallissimilarlypermitted.Inbothcalls,Eistaken to be Number.

        List<Integer> intsss = new ArrayList<Integer>();
        intsss.add(1);
        intsss.add(2);
        List<? extends Number> numss = ints;
        //numss.add(3.14); // compile-time error
        assert intsss.toString().equals("[1, 2, 3.14]"); // uh oh!
//        Before, the fourth line caused a compile - time
//        error(because List < Integer > is not a subtype of List < Number >), but the fifth line was
//        fine(because a double is a number, so you can add a double to a List<Number >).Now, the
//        fourth line is fine (because List<Integer> is a subtype of List<? extends Number >),but the
//        fifth line causes a com - pile - timeerror(becauseyoucannotaddadoubletoaList < ? extends
//        Number >, sinceit might be a list of some other subtype of number)

        List<Object> objs = Arrays.<Object>asList(2, 3.14, "four");
        List<Integer> intssss = Arrays.asList(5, 6);
        Collections.copy(objs, intssss);
        assert objs.toString().equals("[5, 6, four]");
//        The quizzical phrase ? super T means that the destination list may have elements of any type
//        that is a supertype of T or is T itself, just as the source list may have elements of any type that is
//        a subtype of T.

        Collections.copy(objs, ints);
        Collections.<Object>copy(objs, ints);
        Collections.<Number>copy(objs, ints);
        Collections.<Integer>copy(objs, ints);
//        The first call leaves the type parameter implicit;
//        it is taken to be Integer, since that is the most specific choice that works.In the
//        third line, the type parameter T is taken to be Number.The call is permitted because objs
//        has type List<Object>,which is a subtype of List<?super Number > (since Object is
//        a supertype of Number, as required by the wildcard)and ints has type List<Integer>,which is
//        a subtype of List<? extends Num ber>(since Integer is a subtype of Number, as required by
//        the extends wildcard).
//        We could also declare the method with several possible signatures.
//        public static <T> void copy(List<T> dst, List<T> src)
//        public static <T> void copy(List<T> dst, List<? extends T> src)
//        public static <T> void copy(List<? super T> dst, List<T> src)
//        public static <T> void copy(List<? super T> dst, List<? extends T> src)

//        The Get and Put Principle:
//        use an extends wildcard when you only get values out of a structure, use a super
//        wildcard when you only put values into a structure, and don’t use a wildcard when you
//        both get and put.

        public static double sum(Collection<? extends Number> nums) { double s = 0.0;
            for (Number num : nums) s += num.doubleValue();
            return s;
        }
       // Since this uses extends, all of the following calls are legal:
        List<Integer> intes = Arrays.asList(1,2,3);
        assert sum(intes) == 6.0;
        List<Double> doubles = Arrays.asList(2.78,3.14); assert sum(doubles) == 5.92;
        List<Number> numms = Arrays.<Number>asList(1,2,2.78,3.14); assert sum(numms) == 8.92;
       // The first two calls would not be legal if extends was not used.

        public static void count(Collection<? super Integer> ints, int n) {
            for (int i = 0; i < n; i++) ints.add(i); }
        //Since this uses super, all of the following calls are legal:
        List<Integer> ints = new ArrayList<Integer>(); count(ints, 5);
        assert ints.toString().equals("[0, 1, 2, 3, 4]");
        List<Number> nums = new ArrayList<Number>(); count(nums, 5); nums.add(5.0);
        assert nums.toString().equals("[0, 1, 2, 3, 4, 5.0]");
        List<Object> objs = new ArrayList<Object>(); count(objs, 5); objs.add("five");
        assert objs.toString().equals("[0, 1, 2, 3, 4, five]");
//        The last two calls would not be legal if super was not used.
//            Whenever you both put values into and get values out of the same structure, you should
//        not use a wildcard.
        public static double sumCount(Collection<Number> nums, int n) { count(nums, n);
            return sum(nums); }
//        The collection is passed to both sum and count, so its element type must both extend
//        Number(as sum requires) and be super to Integer (as count requires).The only two classes
//        that satisfy both of these constraints are Number and Integer, and we have picked the
//        first of these.Here is a sample call:
        List<Number> nums = new ArrayList<Number>(); double sum = sumCount(nums,5);
        assert sum == 10;
       // Since there is no wildcard, the argument must be a collection of Number.

//        The Get and Put Principle also works the other way around.If an extends wildcard is
//        present, pretty much all you will be able to do is get but not put values of that type;
//        and if a super wildcard is present, pretty much all you will be able to do is put but not get values of that type.
//            For example, consider the following code fragment, which uses a list declared with an extends
//        wildcard:
        List<Integer> ints = new ArrayList<Integer>(); ints.add(1);
        ints.add(2);
        List<? extends Number> nums = ints;
        double dbl = sum(nums); // ok nums.add(3.14); // compile-time error
//        The call to sum is fine, because it gets values from the list, but the call to add
//        is not, because it puts a value into the list.This is just as well, since otherwise we
//        could add a double to a list of integers !
//            Conversely, consider the following code fragment, which uses a list declared with a
//        super wildcard:
        List<Object> objs = new ArrayList<Object>(); objs.add(1);
        objs.add("two");
        List<? super Integer> ints = objs; ints.add(3); // ok
        double dbl = sum(ints); // compile-time error
//        Now the call to add is fine, because it puts a value into the list, but the call to sum
//        is not, because it gets a value from the list.This is just as well, because the sum of a
//        list containing a string makes no sense !
//            The exception proves the rule, and each of these rules has one exception.You cannot
//        put anything into a type declared with an extends wildcard—except for the value null, which
//        belongs to every reference type:
        List<Integer> ints = new ArrayList<Integer>(); ints.add(1);
        ints.add(2);
        List<? extends Number> nums = ints; nums.add(null); // ok
        assert nums.toString().equals("[1, 2, null]");
//        Similarly, you cannot get anything out from a type declared with a super wildcard—
//        except for a value of type Object, which is a supertype of every reference type:
        List<Object> objs = Arrays.<Object>asList(1,"two"); List<? super Integer> ints = objs;
        String str = "";
        for (Object obj : ints) str += obj.toString(); assert str.equals("1two");
//        You may find it helpful to think of ? extends T as containing every type in an interval
//        bounded by the type of null below and by T above(where the type of null is a
//        subtype ofeveryreferencetype).Similarly, youmaythinkof ? super Tascontainingeverytype in
//        an interval bounded by T below and by Object above.

    }

}
