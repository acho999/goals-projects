package com.angel.models.entities;

import com.angel.models.dto.UserDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Users")
public class User implements Serializable {

    @Id
    @Column(name = "Id", unique = true, nullable = false)
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @ApiModelProperty(notes = "Id of the Student",name="id",required=true,value="test id")
    private String id;

    @ApiModelProperty(notes = "Name of the User",name="name",required=true,value="test name")
    @Column(name = "name")
    private String fullName;

    @ApiModelProperty(notes = "Email of the Student",name="email",required=true,value="test email")
    @Column(name = "email")
    private String email;

    public User(String name, String email){
        this.fullName = name;
        this.email = email;
    }

    public static User of(UserDto dto){
        return new User(dto.getFullName(), dto.getEmail());
    }

}
