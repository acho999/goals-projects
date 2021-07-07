package com.in28minutes.database.databasedemo.singleTableInheritance;

import java.math.BigDecimal;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("PartTime")//here we add this anotation in order to have walues in DiscriminatorColumn
public class PartTimeEmployee extends Employee{

 private BigDecimal hourlyWage;

    public PartTimeEmployee() {
    }

    public PartTimeEmployee(String name, BigDecimal hourlyWage){
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
