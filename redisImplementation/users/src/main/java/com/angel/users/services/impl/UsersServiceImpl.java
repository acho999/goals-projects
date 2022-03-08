package com.angel.users.services.impl;

import com.angel.models.dto.UserDto;
import com.angel.models.entities.User;
import com.angel.users.exceptions.UserNotFoundException;
import com.angel.users.repositories.UsersRepository;
import com.angel.users.services.api.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Logger;

import javax.transaction.Transactional;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository repository;
    private static final Logger logger = Logger.getLogger(UsersServiceImpl.class.getSimpleName());

    @Override
    public UserDto getUser(String id) {
        User user = null;
        try {
             user = this.repository.findById(id).get();
        } catch (NoSuchElementException ex) {
            throw new UserNotFoundException(ex.getMessage(), ex);
        }
        return UserDto.of(user);
    }

    @Override
    public UserDto createUser(UserDto user) {
        User entity = User.of(user);
        this.repository.saveAndFlush(entity);
        user.setId(entity.getId());
        return user;
    }

    @Override
    public boolean deleteUser(String id) {
        this.repository.deleteById(id.toString());
        return true;
    }

    @Override
    public Collection<UserDto> getAllUsers() {
        List<UserDto> users = (List<UserDto>) UserDto.ofAll(this.repository.findAll());
        return users;
    }

    @Override
    public UserDto updateUser(UserDto dto) {
        User user = null;
        try {
            user = this.repository.findById(dto.getId().toString()).get();
            mapToUser(dto,user);
            this.repository.saveAndFlush(user);
        } catch (NoSuchElementException ex) {
            throw new UserNotFoundException(ex.getMessage());
        }
        return UserDto.of(user);
    }

    private void mapToUser(UserDto dto, User user){
        user.setEmail(dto.getEmail());
        user.setFullName(dto.getFullName());
    }
}
