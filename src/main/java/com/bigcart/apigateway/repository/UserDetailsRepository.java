package com.bigcart.apigateway.repository;


import com.bigcart.apigateway.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDetailsRepository extends JpaRepository<User,Integer> {

    Optional<User> findByUsername(String name);
    boolean existsByUsername(String username);
//    Optional<User> findByUserModelId(String userModelId);
//    boolean existsByUserModelId(String userModelId);
//    boolean deleteByUserModelId(String userModelId);
}
