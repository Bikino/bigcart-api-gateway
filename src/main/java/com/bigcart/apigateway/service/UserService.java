package com.bigcart.apigateway.service;

import com.bigcart.apigateway.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    public ResponseEntity saveUser(User user);
    public User getUserByUsername(String username);
//    public User getUserById(String userModelId);
//    public User updateUser(String userModelId, User user);
//    public List<User> getAllUser(String userModelId);
//    public boolean deleteUser(String userModelId);
}
