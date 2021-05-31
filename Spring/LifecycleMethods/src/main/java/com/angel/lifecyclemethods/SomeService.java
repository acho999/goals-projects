package com.angel.lifecyclemethods;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class SomeService {

    public SomeService(){

        System.out.println("Inside default constructor");

    };

    @PostConstruct
    public void postConstruct(){

        System.out.println("Inside post construct method");

    }

    @PreDestroy
    public void preDestroy(){

        System.out.println("Inside pre destroy method");

    }

}
