package com.store.back.models.service;

import java.util.List;

import com.store.back.models.entity.RolUser;

public interface IRolUserService {
	RolUser saveRolUser(RolUser rolUser);
    List<RolUser> getAllRolUsers();
    RolUser getRolUserById(Long id);
    void deleteRolUser(Long id);
    List<RolUser> getRolUsersByUserId(Long userId);
    List<RolUser> getRolUsersByRoleId(Long roleId);
    List<RolUser> getRolUsersByUserUsername(String username);
    List<RolUser> getRolUsersByRolName(String rolename);
}
