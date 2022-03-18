package com.angel.users.services.api;

import com.angel.models.dto.UserDto;

import java.util.Collection;

public interface UsersService {

    UserDto getUser(String id);
    UserDto createUser(UserDto user);
    boolean deleteUser(String id);
    Collection<UserDto> getAllUsers();
    UserDto updateUser(UserDto user);

}
