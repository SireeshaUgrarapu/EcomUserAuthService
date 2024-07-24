package com.siri.EcomUserAuthService.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class RoleRequestDTO {
    private UUID roleId;
    private String roleName;
    private String description;
}
