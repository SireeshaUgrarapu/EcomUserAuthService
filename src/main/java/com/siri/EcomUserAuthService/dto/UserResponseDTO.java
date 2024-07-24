package com.siri.EcomUserAuthService.dto;

import com.siri.EcomUserAuthService.entity.Role;
import com.siri.EcomUserAuthService.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class UserResponseDTO {
    private String name;
    private String email;
    private List<RoleResponseDTO> roles;
    private String token;

    public static UserResponseDTO from (User user){
        if(user == null ){
            return null;
        }
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.name = user.getName();
        userResponseDTO.email= user.getEmailId();
        userResponseDTO.token= user.getToken();
        userResponseDTO.roles= new ArrayList<>();
        //todo convert lambda stream
        for(Role role :user.getRoles()){
            RoleResponseDTO responseDTO = new RoleResponseDTO();
            responseDTO.setDesc(role.getDescription());
            responseDTO.setRole(role.getRoleName());
            userResponseDTO.roles.add(responseDTO);

        }
        return userResponseDTO;
    }
    //demo ex
    public static User from(UserResponseDTO userResponseDTO){
        return null;
    }
}
