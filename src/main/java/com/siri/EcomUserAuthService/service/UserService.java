package com.siri.EcomUserAuthService.service;

import com.siri.EcomUserAuthService.dto.LoginRequestDTO;
import com.siri.EcomUserAuthService.dto.SignupRequestDTO;
import com.siri.EcomUserAuthService.dto.UserResponseDTO;
import org.springframework.stereotype.Service;

import javax.management.relation.RoleNotFoundException;


public interface UserService {
    UserResponseDTO signup(SignupRequestDTO signupRequestDTO) throws RoleNotFoundException;
    UserResponseDTO login(LoginRequestDTO loginRequestDTO);
    boolean validateToken(String token);
    boolean logout(String token);
}
