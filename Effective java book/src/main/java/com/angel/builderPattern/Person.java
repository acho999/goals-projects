package com.angel.builderPattern;

public class Person {

    private final String name;//required fields because of final must be initialised at declaration or in constructor
    private final int age;
    private double height;
    private double weight;

    public static class Builder{

        private final String name;
        private final int age;
        private double height = 0.0d;
        private double weight = 0.0d;

        public Builder(String name, int age){//here are initialised required fields
            this.name = name;
            this.age = age;
        }
        public Builder setHeight (double height){
            height = height;
            return this;
        }
        public Builder setWeight (double weight){
            weight = weight;
            return this;
        }
        public Person build(){
            return new Person(this);
        }

    }

    private Person(Builder builder){
        this.name = builder.name;
        this.age = builder.age;
        this.weight = builder.weight;
        this.height = builder.height;
    }

}
