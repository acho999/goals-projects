package com.in28minutes.database.databasedemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "passports")
public class Passport {



    @Id
    @GeneratedValue
    private Long Id;

    @Column(nullable = false,name = "passportNumber")
    private String number;

    @OneToOne(optional = false,fetch = FetchType.LAZY,mappedBy = "passport")//that is how we have bydirectional relation one to one
    private Student student;//with adding mappedBy="passport" we tell that the Student entity is owning the
    //relation it is a Parent entity and also in Pasport table we will not have student_id column

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

}
