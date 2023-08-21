package com.store.back.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.back.models.entity.RolUser;
import com.store.back.models.repository.RolUserRepository;

@Service
public class RolUserServiceImpl implements IRolUserService {

    private final RolUserRepository rolUserRepository;

    @Autowired
    public RolUserServiceImpl(RolUserRepository rolUserRepository) {
        this.rolUserRepository = rolUserRepository;
    }

    @Override
    public RolUser saveRolUser(RolUser rolUser) {
        return rolUserRepository.save(rolUser);
    }

    @Override
    public List<RolUser> getAllRolUsers() {
        return rolUserRepository.findAll();
    }

    @Override
    public RolUser getRolUserById(Long id) {
        return rolUserRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteRolUser(Long id) {
        rolUserRepository.deleteById(id);
    }

    @Override
    public List<RolUser> getRolUsersByUserId(Long userId) {
        return rolUserRepository.findByUserId(userId);
    }

    @Override
    public List<RolUser> getRolUsersByRoleId(Long roleId) {
        return rolUserRepository.findByRolesId(roleId);
    }

    @Override
    public List<RolUser> getRolUsersByUserUsername(String username) {
        return rolUserRepository.findByUserUsername(username);
    }

    @Override
    public List<RolUser> getRolUsersByRolName(String rolename) {
        return rolUserRepository.findByRolesName(rolename);
    }
}
