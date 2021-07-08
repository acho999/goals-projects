package com.in28minutes.database.databasedemo.mappedSuperClassInheritance;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class PartTimeEmployee3 extends Employee3 {

 private BigDecimal hourlyWage;

    public PartTimeEmployee3() {
    }

    public PartTimeEmployee3(String name, BigDecimal hourlyWage){
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
