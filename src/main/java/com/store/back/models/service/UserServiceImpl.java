package com.store.back.models.service;

import com.store.back.models.entity.User;
import com.store.back.models.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class UserServiceImpl implements IUserService {

	private List<User> users = new ArrayList<>();
	//private Long nextId = 1L;

    
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
   

    @Override
    public boolean isUserExists(String username) {
        return userRepository.existsByUsername(username);
    }

    
    @Override
    public User registerUser(User user) {
    	
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("Username already exists"); // O manejo más adecuado para manejar el error
        }
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword); // Asigna la contraseña encriptada al objeto User
        
        userRepository.save(user);
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
    	PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        User user = userRepository.findByUsername(username);
        boolean passwordsMatch = encoder.matches(password, user.getPassword());
        if(passwordsMatch) {
        	return user;
        } else {
        	return null;
        }
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
