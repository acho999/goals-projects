package com.angel.abstractBuilderPattern;

import java.util.Objects;

public class NyPizza extends Pizza{

    public enum Size { SMALL, MEDIUM, LARGE }
    private final Size size;

    public static class Builder extends Pizza.Builder<Builder>{

        private final Size size;

        public Builder (Size size){
            this.size = Objects.requireNonNull(size);
        }

        @Override
        protected Builder self() {//implementation of abstract methods
            return this;
        }

        @Override
        public NyPizza build() {
            return new NyPizza(this);//here we give an instance of builder to private constructor and this instance is passed to Pizza super() parent constructor
        }//"this" is equal to builder instance
    }

    private NyPizza(Builder builder) {
        super(builder);
        this.size = builder.size;
    }
}
