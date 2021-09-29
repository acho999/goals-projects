package com.angel.abstractBuilderPattern;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public abstract class Pizza {
    public enum Topping {HAM, MUSHROOM, ONION, PAPER, SAUSIGE};
    final Set<Topping> toppings;

    abstract static class Builder<T extends Builder>{//generic type with recursive type parameter this class is protected
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);//empty collection

        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();//this is in order to chain and add different toppings that is why it self() returns "this" which refer to child class "this returns same object of child class"
        }//builders can aggregate the parameters passed into multiple calls to a method into a single field, as demonstrated in the addTopping method earlier.

        protected abstract T self();//this will wrap this in child classes
        abstract Pizza build();//that way every child class will implement it and will return its own pizza variant
    }
    Pizza(Builder<?> builder){
        this.toppings = builder.toppings.clone();//defensive copy
    }//here we add toppings to toppings field from builder object passed from child class

}
