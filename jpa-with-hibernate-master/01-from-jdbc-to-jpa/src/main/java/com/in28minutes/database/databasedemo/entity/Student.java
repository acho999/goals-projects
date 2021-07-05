package com.in28minutes.database.databasedemo.entity;

import net.bytebuddy.asm.Advice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Students")
public class Student {



    @Id
    @GeneratedValue
    private Long Id;

    @Column(nullable = false,name = "fullName")
    private String name;

    @OneToOne(optional = false,fetch = FetchType.LAZY)//in one to one relation we have Eager loading of passport by default
    //when we retrieve Student from database. we may use also @OneToOne(optional = false,fetch = FetchType.EAGER)
    //to achieve this.If we want lazy loading of passport we will do following
    // @OneToOne(optional = false,fetch = FetchType.LAZY) that way when we use student.getPassport() then
    //Passport will be retrieved from database
    private Passport passport;

    public Student() {}

    public Student(String name) {
        this.name = name;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }
}
