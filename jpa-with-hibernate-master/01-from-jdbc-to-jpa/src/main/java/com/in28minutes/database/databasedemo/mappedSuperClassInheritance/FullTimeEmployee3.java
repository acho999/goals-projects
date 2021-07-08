package com.in28minutes.database.databasedemo.mappedSuperClassInheritance;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class FullTimeEmployee3 extends Employee3 {

    private BigDecimal salary;

    public FullTimeEmployee3() {
    }

    public FullTimeEmployee3(String name, BigDecimal salary) {
        super(name);
        this.salary = salary;
    }
}
