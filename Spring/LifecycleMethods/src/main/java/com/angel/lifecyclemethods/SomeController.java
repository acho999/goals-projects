package com.angel.lifecyclemethods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class SomeController {

    private SomeService service;

    @Autowired
    public SomeController(SomeService service){
        this.service = service;
    }

}
