package com.angel.users.services.impl;

import com.angel.models.dto.UserDto;
import com.angel.models.entities.User;
import com.angel.users.controllers.UsersRestController;
import com.angel.users.exceptions.UserNotFoundException;
import com.angel.users.repositories.UsersRepository;
import com.angel.users.services.api.UsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository repository;
    private static final Logger log = LoggerFactory.getLogger(UsersRestController.class);

    @Override
    @Cacheable(value = "users", key = "#id")
    public UserDto getUser(String id) {
        User user = null;
        try {
            user = this.repository.findById(id).get();
            log.info("Users service userId {}",user.getId());
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
        log.debug("Users service userId {}",user.getId());
        return user;
    }

    @Override
    @CacheEvict(value = "users", allEntries = false, key = "#id")
    public boolean deleteUser(String id) {
        this.repository.deleteById(id);
        return true;
    }

    @Override
    @Cacheable(value = "users")
    public Collection<UserDto> getAllUsers() {
        List<UserDto> users = (List<UserDto>) UserDto.ofAll(this.repository.findAll());
        log.debug("Userrs: {}",users);
        return users;
    }

    @Override
    @CachePut(value = "users", key = "#dto.id")
    public UserDto updateUser(UserDto dto) {
        User user = null;
        try {
            user = this.repository.findById(dto.getId()).get();
            mapToUser(dto, user);
            this.repository.saveAndFlush(user);
        } catch (NoSuchElementException ex) {
            throw new UserNotFoundException(ex.getMessage());
        }
        return UserDto.of(user);
    }

    private void mapToUser(UserDto dto, User user) {
        user.setEmail(dto.getEmail());
        user.setFullName(dto.getFullName());
    }
}
