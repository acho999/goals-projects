package com.in28minutes.database.databasedemo.singleTableInheritance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.DiscriminatorColumn;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)//here we tell the type of inheritance
//that way we will have one table Employee in which we will have column DTYPE which stands from
//descriptor type in this column we will contain different types of employees i.e FullTimeEmployee
//and PartTimeEmployee and for PartTimeEmployeecolumn salary will be null and for FullTimeEmployee
//column hourlyWage will be null
@DiscriminatorColumn(name = "Emplyee_Type")//here is rescriminator column in which we will have different types of Employeee
public abstract class Employee {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    public Employee(){}

    public Employee(String name){
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
