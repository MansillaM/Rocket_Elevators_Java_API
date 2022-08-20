package com.codeboxx.Rocket_Elevators_Java_Api.Services;

import java.util.List;
import java.util.Optional;

import com.codeboxx.Rocket_Elevators_Java_Api.Models.User;
import com.codeboxx.Rocket_Elevators_Java_Api.Repositories.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> allUsers() {

        return userRepository.findAll();
    }

    public User userById(int id) {

        return userRepository.findById(id).get();
    }

    public Optional<User> userByEmail(String email) {
        return userRepository.findByEmail(email);
    }

}
