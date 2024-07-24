package com.siri.EcomUserAuthService.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "ROLE_TABLE")
public class Role extends BaseModel{
    private String roleName;
    private String description;
}
