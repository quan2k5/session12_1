package com.data.session12_2.service;

import com.data.session12_2.model.entity.Role;

import java.util.Set;

public interface RoleService {
    Role findByName(String roleName);
    Set<Role> getDefaultRoles();
}