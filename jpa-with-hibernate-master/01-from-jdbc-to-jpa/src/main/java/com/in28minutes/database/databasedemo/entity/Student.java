package com.in28minutes.database.databasedemo.entity;

import net.bytebuddy.asm.Advice;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Students")
public class Student {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Embedded
    private Address address;//when we do not want to have relation with some entity but we want to
    //have Address in Student we can use @Embedded here and @Embeddable in Address

    @Column(nullable = false,name = "fullName")
    private String name;

    @OneToOne(optional = false,fetch = FetchType.LAZY)//in one to one relation we have Eager loading of passport by default
    //when we retrieve Student from database. we may use also @OneToOne(optional = false,fetch = FetchType.EAGER)
    //to achieve this.If we want lazy loading of passport we will do following
    // @OneToOne(optional = false,fetch = FetchType.LAZY) that way when we use student.getPassport() then
    //Passport will be retrieved from database
    private Passport passport;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "courses")//here we add
    //mappedBy="courses" in order to set owner for the relationship and to not have two mapping tables
    //who will be owner of the relationship is not important but there have to be one
    @JoinTable(name = "STUDENT_COURSE",joinColumns = @JoinColumn(name = "STUDENT_ID")
        ,inverseJoinColumns = @JoinColumn(name ="COURSE_ID"))//here we tell how join table to be named
    //and give names of join columns
    private List<Course> courses = new ArrayList<>();

    public Student() {}

    public Student(String name) {
        this.name = name;
    }


    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }
}
