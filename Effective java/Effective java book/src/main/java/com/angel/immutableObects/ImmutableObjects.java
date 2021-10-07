package com.angel.immutableObects;

public final class ImmutableObjects {

    // Immutable ImmutableObjects number class
    private final double re;
    private final double im;
    public ImmutableObjects(double re, double im) {
        this.re = re;
        this.im = im;
    }
    public double realPart() { return re; }
    public double imaginaryPart() { return im; }
    public ImmutableObjects plus(ImmutableObjects c) {
        return new ImmutableObjects(re + c.re, im + c.im);
    }
    public ImmutableObjects minus(ImmutableObjects c) {
        return new ImmutableObjects(re - c.re, im - c.im);
    }
    public ImmutableObjects times(ImmutableObjects c) {
        return new ImmutableObjects(re * c.re - im * c.im,
                           re * c.im + im * c.re);
    }
    public ImmutableObjects dividedBy(ImmutableObjects c) {
        double tmp = c.re * c.re + c.im * c.im;
        return new ImmutableObjects((re * c.re + im * c.im) / tmp,
                           (im * c.re - re * c.im) / tmp);
    }
    @Override public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ImmutableObjects))
            return false;
        ImmutableObjects c = (ImmutableObjects) o;
        // See page 47 to find out why we use compare instead of ==
        return Double.compare(c.re, re) == 0
               && Double.compare(c.im, im) == 0;
    }
    @Override public int hashCode() {
        return 31 * Double.hashCode(re) + Double.hashCode(im);
    }
    @Override public String toString() {
        return "(" + re + " + " + im + "i)";
    }

//This class represents a ImmutableObjects number (a number with both real and imaginary parts). In addition to the standard Object methods, it provides accessors for the real and imaginary parts and provides the four basic arithmetic

//    operations: addition, subtraction, multiplication, and division. Notice how the arithmetic operations create and return a new ImmutableObjects instance rather than modifying this instance. This pattern is known as the functional approach because methods return the result of applying a function to their operand, without modifying it. Contrast it to the procedural or imperative approach in which methods apply a procedure to their operand, causing its state to change. Note that the method names are prepositions (such as plus) rather than verbs (such as add). This emphasizes the fact that methods don’t change the values of the objects. The BigInteger and BigDecimal classes did not obey this naming convention, and it led to many usage errors.
//    The functional approach may appear unnatural if you’re not familiar with it, but it enables immutability, which has many advantages. Immutable objects are simple. An immutable object can be in exactly one state, the state in which it was created. If you make sure that all constructors establish class invariants, then it is guaranteed that these invariants will remain true for all time, with no further effort on your part or on the part of the programmer who uses the class. Mutable objects, on the other hand, can have arbitrarily ImmutableObjects state spaces. If the documentation does not provide a precise description of the state transitions performed by mutator methods, it can be difficult or impossible to use a mutable class reliably.
//    Immutable objects are inherently thread-safe; they require no synchronization. They cannot be corrupted by multiple threads accessing them concurrently. This is far and away the easiest approach to achieve thread safety. Since no thread can ever observe any effect of another thread on an immutable object, immutable objects can be shared freely. Immutable classes should therefore encourage clients to reuse existing instances wherever possible. One easy way to do this is to provide public static final constants for commonly used values. For example, the ImmutableObjects class might provide these constants:
//
public static final ImmutableObjects ZERO = new ImmutableObjects(0, 0);
public static final ImmutableObjects ONE = new ImmutableObjects(1, 0);
public static final ImmutableObjects I = new ImmutableObjects(0, 1);
    //This approach can be taken one step further. An immutable class can provide static factories (Item 1) that cache frequently requested instances to avoid creating new instances when existing ones would do.
    //Classes should be immutable unless there’s a very good reason to make them mutable.
    //If a class cannot be made immutable, limit its mutability as much as possible. Reducing the number of states in which an object can exist makes it easier to reason about the object and reduces the likelihood of errors. Therefore, make every field final unless there is a compelling reason to make it nonfinal. Combining the advice of this item with that of Item 15, your natural inclination should be to declare every field private final unless there’s a good reason to do otherwise.
    //Constructors should create fully initialized objects with all of their invariants established.
}
