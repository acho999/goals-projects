package com.angel.managementservice.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@ControllerAdvice
@RequestMapping("/management")
public class ManagementController {

    @Autowired
    private Environment env;

    private static final String REQUEST_URL = "http://localhost:8082/users-service/users/isWorking";

    private final RestTemplate template = new RestTemplate();

    @GetMapping("/isWorking")
    public ResponseEntity<String> isManagementWorking() {
        return ResponseEntity.ok("Instance of Users service is working on port - " + env.getProperty("local.server.port"));
    }

    @GetMapping("/isUsersWorking")
    public ResponseEntity<String> isUsersServiceWorking() {
        return template.exchange(REQUEST_URL, HttpMethod.GET, null, String.class);
    }
}
