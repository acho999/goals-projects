package com.in28minutes.database.databasedemo.entity;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class Review {

    @Id
    @GeneratedValue
    private Long Id;

    @Column(nullable = false, name = "description")
    private String description;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Course course;

    public Review(){}

    public Review(String descr){}

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

}
