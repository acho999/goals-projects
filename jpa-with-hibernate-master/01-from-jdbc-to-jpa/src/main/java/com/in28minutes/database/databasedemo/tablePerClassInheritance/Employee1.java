package com.in28minutes.database.databasedemo.tablePerClassInheritance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.DiscriminatorColumn;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)//this will create table per conrete class entity
//concrete classes are PartTimeEmployee and FullTimeEmployee the both will have id and name columns
public abstract class Employee1 {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    public Employee1(){}

    public Employee1(String name){
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
