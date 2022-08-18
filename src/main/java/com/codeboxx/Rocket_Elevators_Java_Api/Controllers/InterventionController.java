package com.codeboxx.Rocket_Elevators_Java_Api.Controllers;

import java.nio.file.FileSystemNotFoundException;
import java.util.List;

import com.codeboxx.Rocket_Elevators_Java_Api.Models.Intervention;
import com.codeboxx.Rocket_Elevators_Java_Api.Repositories.InterventionRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InterventionController {

    private final InterventionRepository repository;
    InterventionController(InterventionRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/interventions")
    List<Intervention> all() {
        return repository.findAll();
    }

    @GetMapping("/intervention/{id}")
    Intervention one(@PathVariable int id) {

        return repository.findById(id)
                .orElseThrow(FileSystemNotFoundException::new);
    }

}
