package com.store.back.models.service;

import com.store.back.models.entity.User;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;



@Service
public class UserServiceImpl implements IUserService {

	private List<User> users = new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public User registerUser(User user) {
        user.setUserId(nextId++);
        users.add(user);
        return user;
    }

    @Override
    public User updateUser(Long id, User user) {
        User existingUser = findUserById(id);

        if (existingUser != null) {
            existingUser.setUsername(user.getUsername());
            existingUser.setPassword(user.getPassword());
        }

        return existingUser;
    }

    @Override
    public void deleteUser(Long id) {
        User user = findUserById(id);
        if (user != null) {
            users.remove(user);
        }
    }

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    private User findUserById(Long id) {
        for (User user : users) {
            if (user.getUserId().equals(id)) {
                return user;
            }
        }
        return null;
    }
    
}
