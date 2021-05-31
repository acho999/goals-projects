package com.Angel.demo.controllers;

import com.Angel.demo.services.MyPrototypeScopeService;
import com.Angel.demo.services.MyRequestScopeService;
import com.Angel.demo.services.MySingeltonScopeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class MyController {

    Logger log = LoggerFactory.getLogger(MyController.class);

    @Value(value = "${home}")
    public String a;

    @Autowired
    public Environment env;

    @Autowired
    public MyRequestScopeService service;

    @Autowired
    public MyRequestScopeService service1;

    @Autowired
    public MyPrototypeScopeService another;

    @Autowired
    public MyPrototypeScopeService another1;

    @Autowired
    public MySingeltonScopeService second;

    @Autowired
    public MySingeltonScopeService second1;

    @RequestMapping(value = "/hello")
    public String getSomething(){

        log.info(service.toString() + "///" + another.toString() + "///" + second.toString());
        log.info(service1.toString() + "///" + another1.toString() + "///" + second1.toString());

        return this.a + "///" + this.env.getProperty("home");
    }

}
