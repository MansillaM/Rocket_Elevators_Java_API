package com.codeboxx.Rocket_Elevators_Java_Api.Controllers;

import java.util.List;
import com.codeboxx.Rocket_Elevators_Java_Api.Models.Elevator;
import com.codeboxx.Rocket_Elevators_Java_Api.Services.ElevatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/elevator")
public class ElevatorController {

    private final ElevatorService elevatorService;

    ElevatorController(ElevatorService elevatorService) {
        this.elevatorService = elevatorService;
    }

    @GetMapping("/all")
    public List<Elevator> getAllElevators() {

        return elevatorService.allElevators();
    }

    @GetMapping("id/{id}")
    public Elevator getById(@PathVariable int id) {

        return (Elevator) elevatorService.elevatorById(id);
    }

}
