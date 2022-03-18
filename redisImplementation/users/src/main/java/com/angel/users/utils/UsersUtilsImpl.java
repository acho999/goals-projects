package com.angel.users.utils;

import com.angel.models.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UsersUtilsImpl implements UsersUtils {


    @Override
    public String getUserData(UserDto user) {
        String result = String.format("{UserId : %s, Name : %s}",user.getId(), user.getFullName());
        return result;
    }
}
