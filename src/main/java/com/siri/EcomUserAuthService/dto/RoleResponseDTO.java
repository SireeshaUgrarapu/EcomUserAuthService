package com.siri.EcomUserAuthService.dto;

import com.siri.EcomUserAuthService.entity.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class RoleResponseDTO {
    private UUID id;
    private String role;
    private String desc;

    public static RoleResponseDTO from(Role role){
        RoleResponseDTO responseDTO = new RoleResponseDTO();
        responseDTO.id= role.getId();
        responseDTO.role = role.getRoleName();
        responseDTO.desc = role.getDescription();
        return  responseDTO;
    }
}
