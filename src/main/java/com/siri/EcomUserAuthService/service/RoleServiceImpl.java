package com.siri.EcomUserAuthService.service;

import com.siri.EcomUserAuthService.dto.RoleRequestDTO;
import com.siri.EcomUserAuthService.dto.RoleResponseDTO;
import com.siri.EcomUserAuthService.entity.Role;
import com.siri.EcomUserAuthService.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements  RoleService{
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public RoleResponseDTO createRole(RoleRequestDTO roleRequestDTO) {
        Role role = new Role();
        role.setId(roleRequestDTO.getRoleId());
        role.setRoleName(roleRequestDTO.getRoleName());
        role.setDescription(roleRequestDTO.getDescription());
        return RoleResponseDTO.from(roleRepository.save(role));
    }
}
