package com.store.back.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.store.back.models.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
    
    @Query("select u from User u where u.username=?1")
    public User getUserByUsername(String username);
    
    boolean existsByUsername(String username);
    
    @Query("select u from User u where u.username=?1 and u.password=?2")
    public User findUserByUsernameAndPassword(String username, String password);
    
    
}

