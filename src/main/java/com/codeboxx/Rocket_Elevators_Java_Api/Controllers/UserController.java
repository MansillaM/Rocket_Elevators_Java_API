package com.codeboxx.Rocket_Elevators_Java_Api.Controllers;

import java.util.List;
import com.codeboxx.Rocket_Elevators_Java_Api.Models.User;
import com.codeboxx.Rocket_Elevators_Java_Api.Services.UserService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserController{

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {

        return userService.allUsers();
    }

    @GetMapping("/{id}")
    public User getByUserId(@PathVariable int id) {

        return userService.userById(id);
    }

}
