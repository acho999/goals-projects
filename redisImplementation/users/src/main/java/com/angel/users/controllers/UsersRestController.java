package com.angel.users.controllers;


import com.angel.models.dto.UserDto;
import com.angel.users.services.api.UsersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@Api(value = "UsersRestController")
@RestController
@RequestMapping(value = "/users")
public class UsersRestController {

    @Autowired
    private UsersService usersService;

    private static final Logger log = LoggerFactory.getLogger(UsersRestController.class);

    @ApiOperation(value = "Creates user")
    @RequestMapping(value = "/create",
        method = RequestMethod.POST,
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        UserDto dto = this.usersService.createUser(userDto);
        ResponseEntity<UserDto> user = new ResponseEntity<>(dto, HttpStatus.CREATED);
        return user;
    }

    @ApiOperation(value = "Updates user")
    @RequestMapping(value = "/update",
        method = RequestMethod.PUT,
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto) {
        UserDto dto = this.usersService.updateUser(userDto);
        ResponseEntity<UserDto> user = new ResponseEntity<>(dto, HttpStatus.OK);
        return user;
    }

    @ApiOperation(value = "Deletes user")
    @RequestMapping(value = "/delete/{userId}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> deleteUser(@PathVariable String userId) {
        boolean isDeleted = this.usersService.deleteUser(userId);
        ResponseEntity<Boolean> response = new ResponseEntity<>(isDeleted, HttpStatus.OK);
        return response;
    }

    @ApiOperation(value = "Gets list of all users")
    @RequestMapping(value = "/getAll",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Collection<UserDto>> getAll() {
        Collection<UserDto> allUsers = this.usersService.getAllUsers();
        ResponseEntity<Collection<UserDto>> usersResponse = new ResponseEntity<>(allUsers, HttpStatus.OK);
        return usersResponse;
    }

    @ApiOperation(value = "Gets user by id")
    @RequestMapping(value = "/get/{userId}",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> getUser(@PathVariable String userId) {
        UserDto dto = this.usersService.getUser(userId);
        log.info("Users controller userId {}",userId);
        ResponseEntity<UserDto> user = new ResponseEntity<>(dto, HttpStatus.OK);
        return user;
    }

}
