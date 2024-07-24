package com.siri.EcomUserAuthService.controller;

import com.siri.EcomUserAuthService.dto.LoginRequestDTO;
import com.siri.EcomUserAuthService.dto.SignupRequestDTO;
import com.siri.EcomUserAuthService.dto.UserResponseDTO;
import com.siri.EcomUserAuthService.service.UserService;
import com.siri.EcomUserAuthService.service.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import javax.management.relation.RoleNotFoundException;
import java.util.UUID;

public class UserControllerTest {
    @Mock
    private UserServiceImpl userService;
    @InjectMocks
    private UserController userController;
    @BeforeEach
    public void  setUp(){
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testSignUpSuccess() throws RoleNotFoundException {
        SignupRequestDTO signupRequest = new SignupRequestDTO();
        signupRequest.setEmail("Siri@123");
        signupRequest.setPassword("1234");
        signupRequest.setName("Siri");
        signupRequest.setRoleId(UUID.randomUUID());

        UserResponseDTO userResponse = new UserResponseDTO();
        userResponse.setEmail("Siri@gmail.com");
        userResponse.setName("Siri");

        Mockito.when(userService.signup(signupRequest)).thenReturn(userResponse);

        ResponseEntity<UserResponseDTO> userResponseDTOResponseEntity = userController.signup(signupRequest);

        Assertions.assertEquals(userResponse,userResponseDTOResponseEntity.getBody());
    }
    @Test
    public void testLoginSuccess(){
        //Arrange
        LoginRequestDTO loginRequestDTO = new LoginRequestDTO();
        loginRequestDTO.setEmail("a@gmail.com");
        loginRequestDTO.setPassword("1234");
        UserResponseDTO userResponse = new UserResponseDTO();
        userResponse.setName("Siri");
        userResponse.setEmail("a@gmail.com");

        Mockito.when(userService.login(loginRequestDTO)).thenReturn(userResponse);

        //act
        ResponseEntity<UserResponseDTO> userResponseDTOResponseEntity = userController.login(loginRequestDTO);
        //assert or checks
        Assertions.assertEquals(userResponse,userResponseDTOResponseEntity.getBody());

    }
}


