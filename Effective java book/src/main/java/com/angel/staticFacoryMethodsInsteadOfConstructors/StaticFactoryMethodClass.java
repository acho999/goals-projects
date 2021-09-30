package com.angel.staticFacoryMethodsInsteadOfConstructors;

public class StaticFactoryMethodClass {

    String name;

    public static StaticFactoryMethodClass of(String name){
        StaticFactoryMethodClass factoryClass = new StaticFactoryMethodClass();
        factoryClass.name = name;
        return factoryClass;
    }

}
