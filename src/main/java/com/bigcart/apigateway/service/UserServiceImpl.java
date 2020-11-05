package com.bigcart.apigateway.service;

import com.bigcart.apigateway.model.User;
import com.bigcart.apigateway.repository.UserDetailsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDetailsRepository userRepository;


    public static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public ResponseEntity saveUser(User user) {

        return userRepository.existsByUsername(user.getUsername()) == true ? new ResponseEntity("Username already exist", HttpStatus.NOT_ACCEPTABLE) :
                new ResponseEntity(userRepository.save(user), HttpStatus.OK);
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }



//    @Override
//    public User getUserById(String id) {
//        return userRepository.findByUserModelId(id).orElse(null);
//    }
//
//
//
//    @Override
//    public User updateUser(String id, User user) {
//        User temp = userRepository.findByUserModelId(id).orElse(null);
//        if (temp != null) {
//            user.setId(temp.getId());
//            return userRepository.save(temp);
//        }
//        return userRepository.save(user);
//    }
//
//
//    @Override
//    public List<User> getAllUser(String id) {
//        List<User> finalList = new ArrayList<>();
//        try {
//            if (id != null) {
//                finalList.add(userRepository.findByUserModelId(id).orElse(null));
//            } else {
//                finalList.addAll(userRepository.findAll());
//            }
//        } catch (Exception e) {
//            logger.error("failed to get Users list");
//        }
//
//        return finalList;
//    }
//
//    @Override
//    public boolean deleteUser(String id) {
//        if (userRepository.existsByUserModelId(id)) {
//            userRepository.deleteByUserModelId(id);
//            return true;
//        }
//        return false;
//    }
}
