package com.in28minutes.database.databasedemo.mappedSuperClassInheritance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

//@Entity mapped super class can't be entity
@MappedSuperclass//that way will be created two separate tables for sub classes, there is not table for super class
public abstract class Employee3 {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    public Employee3(){}

    public Employee3(String name){
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
