package com.angel.models.dto;

import com.angel.models.entities.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    @ApiModelProperty(notes = "Id of the Student",name="id",required=true,value="test id")
    private String id;
    @ApiModelProperty(notes = "Name of the User",name="name",required=true,value="test name")
    private String fullName;
    @ApiModelProperty(notes = "Email of the Student",name="email",required=true,value="test email")
    private String email;

    public static UserDto of(User user){
        return new UserDto(user.getId(), user.getFullName(), user.getEmail());
    }

    public static Collection<UserDto> ofAll(Collection<User> users){
        List<UserDto> allUsers = users.stream().map(x->UserDto.of(x)).collect(Collectors.toList());
        return allUsers;
    }

}
