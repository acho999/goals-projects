package com.angel.singleton;

public class Singleton {

    //first approach with public constant
    // public static final Singleton INSTANCE = new Singleton();//cosnstant which have to be initialized in moment of declaration
    private static final Singleton INSTANCE = new Singleton();//cosnstant which have to be initialized in moment of declaration


    private Singleton(){
        throw new AssertionError();//this enshures that if the constructor is accessed via reflection it will not be instantiated again

    }

    //second approach
    public static Singleton getInstance(){return INSTANCE;}//this i static in order to not create object this is static factory method

}
