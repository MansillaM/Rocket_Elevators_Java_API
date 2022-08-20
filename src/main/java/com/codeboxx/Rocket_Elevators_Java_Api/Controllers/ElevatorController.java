package com.codeboxx.Rocket_Elevators_Java_Api.Controllers;

import java.util.List;
import com.codeboxx.Rocket_Elevators_Java_Api.Models.Elevator;
import com.codeboxx.Rocket_Elevators_Java_Api.Services.ElevatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/elevators")
public class ElevatorController {

    private final ElevatorService elevatorService;

    public ElevatorController(ElevatorService elevatorService) {
        this.elevatorService = elevatorService;
    }

    //for GET method
    @GetMapping("/all")
    public List<Elevator> getAllElevators() {

        return elevatorService.allElevators();
    }

    //for GET method
    @GetMapping("/{id}")
    public Elevator getByElevatorId(@PathVariable int id) {

        return elevatorService.elevatorById(id);
    }



}
