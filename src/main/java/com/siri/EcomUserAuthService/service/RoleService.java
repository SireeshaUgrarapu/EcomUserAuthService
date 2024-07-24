package com.siri.EcomUserAuthService.service;

import com.siri.EcomUserAuthService.dto.RoleRequestDTO;
import com.siri.EcomUserAuthService.dto.RoleResponseDTO;
import org.springframework.stereotype.Service;


public interface RoleService {
    RoleResponseDTO createRole(RoleRequestDTO roleRequestDTO);
}
