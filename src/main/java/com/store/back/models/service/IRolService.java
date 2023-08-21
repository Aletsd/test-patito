package com.store.back.models.service;

import java.util.List;

import com.store.back.models.entity.Rol;

public interface IRolService {
	Rol saveRol(Rol rol);
    List<Rol> getAllRoles();
    Rol getRolById(Long id);
    void deleteRol(Long id);
    Rol getRolByName(String name);
}
