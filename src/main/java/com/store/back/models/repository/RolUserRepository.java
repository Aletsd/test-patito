package com.store.back.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.store.back.models.entity.RolUser;


@Repository
public interface RolUserRepository extends JpaRepository<RolUser, Long> {
	
	@Query("SELECT ru FROM RolUser ru WHERE ru.user.id = :userId")
    List<RolUser> findByUserId(Long userId);

    List<RolUser> findByRolesId(Long roleId);

    List<RolUser> findByUserUsername(String username);

    List<RolUser> findByRolesName(String rolename);
}
