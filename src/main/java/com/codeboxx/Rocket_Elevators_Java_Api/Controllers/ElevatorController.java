package com.codeboxx.Rocket_Elevators_Java_Api.Controllers;

import java.nio.file.FileSystemNotFoundException;
import java.util.List;
import com.codeboxx.Rocket_Elevators_Java_Api.Models.Elevator;
import com.codeboxx.Rocket_Elevators_Java_Api.Repositories.ElevatorRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ElevatorController {

    private final ElevatorRepository repository;
    ElevatorController(ElevatorRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/elevators")
    List<Elevator> all() {
        return repository.findAll();
    }

    @GetMapping("elevators/{id}")
    Elevator one(@PathVariable int id) {

        return repository.findById(id)
                .orElseThrow(() -> new FileSystemNotFoundException());
    }

}
