package com.store.back.models.service;

import com.store.back.models.entity.User;
import java.util.List;

public interface IUserService {

	User registerUser(User user);
    User updateUser(Long id, User user);
    void deleteUser(Long id);
    User findUserByUsernameAndPassword(String username, String password);
    List<User> getAllUsers();
    boolean isUserExists(String username);
   
        
}