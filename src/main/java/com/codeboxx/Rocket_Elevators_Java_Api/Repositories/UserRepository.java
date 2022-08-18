package com.codeboxx.Rocket_Elevators_Java_Api.Repositories;

import com.codeboxx.Rocket_Elevators_Java_Api.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer > {


}
