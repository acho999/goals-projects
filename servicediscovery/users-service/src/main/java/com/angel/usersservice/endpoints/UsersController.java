package com.angel.usersservice.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private Environment env;

    @GetMapping("/isWorking")
    public ResponseEntity<String> isWorking() {
        return ResponseEntity.ok("Instance of Users service is working on port - " + env.getProperty("local.server.port"));
    }

}
