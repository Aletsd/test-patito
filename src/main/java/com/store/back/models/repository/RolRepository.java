package com.store.back.models.repository;


import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.store.back.models.entity.Rol;

@Repository
//PagingAndSortingRepository
public interface RolRepository extends JpaRepository<Rol, Long> {
	public Rol findByName(String name);
}
