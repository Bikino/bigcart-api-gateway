package com.bigcart.apigateway.controller;


import com.bigcart.apigateway.dto.UserDTO;
import com.bigcart.apigateway.model.Permission;
import com.bigcart.apigateway.model.Role;
import com.bigcart.apigateway.model.User;
import com.bigcart.apigateway.repository.UserDetailsRepository;
import com.bigcart.apigateway.service.UserDetailsServicesImpl;
import com.bigcart.apigateway.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserDetailsServicesImpl userDetailsServices;

    @Autowired
    private UserServiceImpl userService;


    @Autowired
    UserDetailsRepository userdetailsRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/createUser")
    public ResponseEntity saveUser(@RequestBody UserDTO userDTO) {

        if (userDTO != null) {
            Permission permission = new Permission(1,"create_profile");
            Role role = new Role(1,"Role_admin",Collections.singletonList(permission));

            User user = new User();
                    user.setUsername(userDTO.getUsername());
                    user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
                    user.setEmail(userDTO.getEmail());
                    user.setAccountNonExpired(true);
                    user.setCredentialsNonExpired(true);
                    user.setAccountNonLocked(true);
                    user.setEnabled(true);
                    user.setRoles(Collections.singletonList(role));
                    userdetailsRepository.save(user);

        }

//            ResponseEntity<User> userSaved = userService.saveUser(user);
//            return userSaved == null ? new ResponseEntity("Username already exist", HttpStatus.NOT_ACCEPTABLE) :
//                    new ResponseEntity(userSaved, HttpStatus.OK);

        return new ResponseEntity("please provide user info", HttpStatus.OK);


    }
}
