package com.in28minutes.database.databasedemo.joinedTableInheritance;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class PartTimeEmployee2 extends Employee2 {

 private BigDecimal hourlyWage;

    public PartTimeEmployee2() {
    }

    public PartTimeEmployee2(String name, BigDecimal hourlyWage){
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
