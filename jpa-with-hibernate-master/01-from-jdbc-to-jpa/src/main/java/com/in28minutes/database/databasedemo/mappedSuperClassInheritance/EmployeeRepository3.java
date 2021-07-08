package com.in28minutes.database.databasedemo.mappedSuperClassInheritance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class EmployeeRepository3 {

    @Autowired
    private EntityManager manager;

    public List getEmployee(){

        return this.manager.createQuery("Select e from Employee2 e").getResultList();
    }

    public void insertEmployee(
        Employee3 employee){
        this.manager.persist(employee);
    }
}
