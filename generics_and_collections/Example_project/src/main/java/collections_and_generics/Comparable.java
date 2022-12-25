package collections_and_generics;

public class Comparable {

    public static void main(String[] args) {
       /*
Example 3-2 prohibits comparison of apples with oranges. Here are the three classes it declares:

class Fruit {...}
class Apple extends Fruit implements Comparable<Apple> {...}
class Orange extends Fruit implements Comparable<Orange> {...}

Each fruit has a name and a size, and two fruits are equal if they have the same name and the same size.
Following good practice, we have also defined a hashCode method, to ensure that equal objects have the same hash code.
Apples are compared by com- paring their sizes, and so are oranges.
Since Apple implements Comparable<Apple>, it is clear that you can compare apples with apples, but not with oranges.
The test code builds three lists, one of apples, one of oranges, and one containing mixed fruits.
We may find the maximum of the first two lists, but attempting to find the maximum of the mixed list signals an error at compile time.

Example 3-1 permits comparison of apples with oranges.
Compare these three class declarations with those given previously
(all differences between Examples Exam- ple 3-2 and Example 3-1 are highlighted):

class Fruit implements Comparable<Fruit> {...}
class Apple extends Fruit {...}
class Orange extends Fruit {...}

As before, each fruit has a name and a size, and two fruits are equal if they have the same name and the same size.
Now any two fruits are compared by ignoring their names and comparing their sizes.
Since Fruit implements Comparable<Fruit>, any two fruits may be compared.

Now the test code can find the maximum of all three lists, including the one that mixes apples with oranges.
       Recall that at the end of the previous section we extended the type signature of compareTo to use super:
        <T extends Comparable<? super T>> T max(Collection<? extends T> coll)
        The second example shows why this wildcard is needed. If we want to compare two
        oranges, we take T in the preceding code to be Orange: Orange extends Comparable<? super Orange>
        And this is true because both of the following hold:
        Orange extends Comparable<Fruit> and Fruit super Orange
        Without the super wildcard, finding the maximum of a List<Orange> would be illegal,
        even though finding the maximum of a List<Fruit> is permitted.
            Also note that the natural ordering used here is not consistent with equals (see Sec- tion 3.1).
            Two fruits with different names but the same size compare as the same, but they are not equal.
    */
    }

}
