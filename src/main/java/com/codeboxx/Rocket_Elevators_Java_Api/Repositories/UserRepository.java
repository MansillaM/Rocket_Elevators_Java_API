package com.codeboxx.Rocket_Elevators_Java_Api.Repositories;

import com.codeboxx.Rocket_Elevators_Java_Api.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer > {

    //for JWT
    Optional<User> findByEmail(String email);

}
