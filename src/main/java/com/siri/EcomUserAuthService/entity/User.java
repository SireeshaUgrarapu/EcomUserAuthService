package com.siri.EcomUserAuthService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "USER_TABLE")
public class User extends BaseModel{
    private String name;
    private String emailId;
    private String password;
    private String token;
    @ManyToMany
    private List<Role> roles;
}
