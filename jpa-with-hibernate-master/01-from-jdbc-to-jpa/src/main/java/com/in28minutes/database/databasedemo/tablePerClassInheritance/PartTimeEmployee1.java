package com.in28minutes.database.databasedemo.tablePerClassInheritance;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class PartTimeEmployee1 extends Employee1 {

 private BigDecimal hourlyWage;

    public PartTimeEmployee1() {
    }

    public PartTimeEmployee1(String name, BigDecimal hourlyWage){
     super(name);
     this.hourlyWage = hourlyWage;
 }

    public BigDecimal getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(BigDecimal hourlyWage) {
        this.hourlyWage = hourlyWage;
    }
}
