package com.siri.EcomUserAuthService.controller;

import com.siri.EcomUserAuthService.dto.RoleRequestDTO;
import com.siri.EcomUserAuthService.dto.RoleResponseDTO;
import com.siri.EcomUserAuthService.service.RoleService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

//public class RoleControllerTest {
//    @Mock
//    private RoleService roleService;
//    @InjectMocks
//    private RoleController roleController;
//    @BeforeEach
//    public void  setUp(){
//        MockitoAnnotations.initMocks(this);
//    }
    //@Test
//    public void testCreateRoleSuccess(){
//        //Arrange
//        RoleRequestDTO roleRequestDTO = new RoleRequestDTO();
//        roleRequestDTO.setRoleName("Admin");
//        roleRequestDTO.setRoleId(UUID.randomUUID());
//        roleRequestDTO.setDescription("Product added");
//
//        RoleResponseDTO responseDTO = new RoleResponseDTO();
//        responseDTO.setId(UUID.randomUUID());
//        responseDTO.setRole("Admin");
//        responseDTO.setDesc("drftghjk");
//        Mockito.when(roleService.createRole(roleRequestDTO)).thenReturn(responseDTO);
//        //act
//        ResponseEntity<RoleResponseDTO> roleResponseDTOResponseEntity = roleController.createRole(roleRequestDTO);
//        //assert
//        Assertions.assertEquals(responseDTO,roleResponseDTOResponseEntity.getBody());
//    }

//}
