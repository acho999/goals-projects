package com.in28minutes.database.databasedemo.tablePerClassInheritance;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class FullTimeEmployee1 extends Employee1 {

    private BigDecimal salary;

    public FullTimeEmployee1() {
    }

    public FullTimeEmployee1(String name, BigDecimal salary) {
        super(name);
        this.salary = salary;
    }
}
