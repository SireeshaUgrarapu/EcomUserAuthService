package com.siri.EcomUserAuthService.service;

import com.siri.EcomUserAuthService.dto.LoginRequestDTO;
import com.siri.EcomUserAuthService.dto.SignupRequestDTO;
import com.siri.EcomUserAuthService.dto.UserResponseDTO;
import com.siri.EcomUserAuthService.entity.Role;
import com.siri.EcomUserAuthService.entity.User;
import com.siri.EcomUserAuthService.exception.InvalidCredentialException;
import com.siri.EcomUserAuthService.exception.RoleNotFoundExceptiom;
import com.siri.EcomUserAuthService.exception.UserNotFoundException;
import com.siri.EcomUserAuthService.repository.RoleRepository;
import com.siri.EcomUserAuthService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;


    @Override
    public UserResponseDTO signup(SignupRequestDTO signupRequestDTO) throws RoleNotFoundExceptiom {
        Role role = roleRepository.findById(signupRequestDTO.getRoleId()).orElseThrow(()-> new RoleNotFoundExceptiom("Roles not found"));
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        User user = new User();
        user.setName(signupRequestDTO.getName());
        user.setEmailId(signupRequestDTO.getEmail());
        user.setPassword(encoder.encode(signupRequestDTO.getPassword()));
        user.setRoles(List.of(role));
        return UserResponseDTO.from(userRepository.save(user));
    }

    @Override
    public UserResponseDTO login(LoginRequestDTO loginRequestDTO) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        User savedUser =userRepository.findByEmailId(loginRequestDTO.getEmail()).orElseThrow(()-> new UserNotFoundException("User Not Found"));
        if(bCryptPasswordEncoder.matches(loginRequestDTO.getPassword(),savedUser.getPassword())){
            String userData=savedUser.getEmailId()+savedUser.getPassword()+ LocalDateTime.now();
            String token = bCryptPasswordEncoder.encode(userData);
            savedUser.setToken(token);
        }else{
            throw new InvalidCredentialException();
        }
        // saved token in the database
         savedUser = userRepository.save(savedUser);
         return UserResponseDTO.from(savedUser);
    }

    @Override
    public boolean validateToken(String token) {
        User savedUser = userRepository.findByToken(token).orElseThrow(() -> new InvalidCredentialException("Token not found"));
        return true;
    }

    @Override
    public boolean logout(String token) {
       User savedUser = userRepository.findByToken(token).orElseThrow(() -> new InvalidCredentialException("Token is not valid"));
       savedUser.setToken(null);
       userRepository.save(savedUser);
       return true;
    }

}
