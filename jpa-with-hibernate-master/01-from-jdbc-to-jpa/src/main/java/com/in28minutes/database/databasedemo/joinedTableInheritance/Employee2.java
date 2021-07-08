package com.in28minutes.database.databasedemo.joinedTableInheritance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.DiscriminatorColumn;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)//here will be created 3 tables for super class and for sub classes
//here we have to perform join to instantiate subclasses in super class tablle we will have only id and name columns
//and in subclass table for example FullTimeEmployee2 we will have only id and salary and the id will have role
//of primary and the same time foreign key and if we want to take salary and name we will have to make join
//SELECT * FROM FUL_TIME_EMPLOYEE_2, EMPLOYEE WHERE FUL_TIME_EMPLOYEE_2.id = EMPLOYEE.id
//in order to retrieve employess details we have to join all three tables
public abstract class Employee2 {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    public Employee2(){}

    public Employee2(String name){
        this.name=name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
