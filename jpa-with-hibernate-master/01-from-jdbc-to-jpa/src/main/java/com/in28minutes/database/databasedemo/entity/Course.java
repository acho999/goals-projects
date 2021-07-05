package com.in28minutes.database.databasedemo.entity;

import java.util.ArrayList;
import java.util.List;
import com.in28minutes.database.databasedemo.entity.Review;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cources")
public class Course {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Review> reviews = new ArrayList<>();

    @Column(nullable = false,name = "name")
    private String name;

    public Course(){}

    public Course(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
