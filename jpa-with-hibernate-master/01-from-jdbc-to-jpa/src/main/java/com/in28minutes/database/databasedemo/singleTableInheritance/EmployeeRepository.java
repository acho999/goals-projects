package com.in28minutes.database.databasedemo.singleTableInheritance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class EmployeeRepository {

    @Autowired
    private EntityManager manager;

    public List<Employee> getEmployee(){

        return this.manager.createQuery("Select e from Employee e").getResultList();
    }

    public void insertEmployee(Employee employee){
        this.manager.persist(employee);
    }
}
