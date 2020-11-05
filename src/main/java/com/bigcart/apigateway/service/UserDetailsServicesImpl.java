package com.bigcart.apigateway.service;

import com.bigcart.apigateway.model.AuthUserDetail;
import com.bigcart.apigateway.model.Employee;
import com.bigcart.apigateway.model.User;
import com.bigcart.apigateway.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service("userDetailsService")
public class UserDetailsServicesImpl implements UserDetailsService {

    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

        Optional<User> optional = userDetailsRepository.findByUsername(name);
        optional.orElseThrow(()-> new UsernameNotFoundException("The username and password are wrong"));

        UserDetails userDetails = new AuthUserDetail(optional.get());

        new AccountStatusUserDetailsChecker().check(userDetails);
        return userDetails;

//        Employee optional = loginProxy.loginEmployee(name);
//
//        User user = new User((int)optional.getId(),
//                optional.getUserName(),
//                optional.getPassword(),
//                optional.isAdmin(),
//                optional.isApproved());
//        optional.orElseThrow(()-> new UsernameNotFoundException("The username and password are wrong"));
//        UserDetails userDetails = new AuthUserDetail(user);

//        Optional<User> optional = userDetailsRepository.findByUsername(name);
//
//        optional.orElseThrow(()-> new UsernameNotFoundException("The username and password are wrong"));
//        UserDetails userDetails = new AuthUserDetail(optional.get());
//
//        new AccountStatusUserDetailsChecker().check(userDetails);
//        return userDetails;


    }

//    public ResponseEntity addUser(User user) {
//
//        return userDetailsRepository.existsByUsername(user.getUsername()) == true ? new ResponseEntity("Username already exist", HttpStatus.NOT_ACCEPTABLE) :
//                new ResponseEntity(userDetailsRepository.save(user), HttpStatus.OK);
//    }

//    @Override
//    public ResponseEntity saveUserToAuthServer(User user) {
//
//        String uri = "http://127.0.0.1:8013/createUser";
//        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
//        HttpEntity<User> entity = new HttpEntity<>(user,headers);
//
//        ResponseEntity userResponseEntity = restTemplate.exchange(uri,HttpMethod.POST,entity,User.class);
//
//        return new ResponseEntity(userResponseEntity,HttpStatus.OK);
//    }

//    public ResponseEntity checkUser(String name, String password) {
//
//        String uri = "http://127.0.0.1:9988/vendor";
//        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
//        HttpEntity<String> entity = new HttpEntity<>(name,headers);
//
//        ResponseEntity userResponseEntity = restTemplate.exchange(uri, HttpMethod.POST,entity,User.class);
//
//        return new ResponseEntity(userResponseEntity,HttpStatus.OK);
//    }

}
