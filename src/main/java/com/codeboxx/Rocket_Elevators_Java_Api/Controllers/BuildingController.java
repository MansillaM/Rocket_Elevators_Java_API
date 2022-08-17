package com.codeboxx.Rocket_Elevators_Java_Api.Controllers;

import java.nio.file.FileSystemNotFoundException;
import java.util.List;
import com.codeboxx.Rocket_Elevators_Java_Api.Models.Building;
import com.codeboxx.Rocket_Elevators_Java_Api.Repositories.BuildingRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BuildingController {

    private final BuildingRepository repository;
    BuildingController(BuildingRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/buildings")
    List<Building> all() {
        return repository.findAll();
    }

    @GetMapping("/buildings/{id}")
    Building one(@PathVariable int id) {

        return repository.findById(id)
                .orElseThrow(() -> new FileSystemNotFoundException());
    }
}
