package com.in28minutes.database.databasedemo.joinedTableInheritance;

import com.in28minutes.database.databasedemo.tablePerClassInheritance.Employee1;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class FullTimeEmployee2 extends Employee1 {

    private BigDecimal salary;

    public FullTimeEmployee2() {
    }

    public FullTimeEmployee2(String name, BigDecimal salary) {
        super(name);
        this.salary = salary;
    }
}
