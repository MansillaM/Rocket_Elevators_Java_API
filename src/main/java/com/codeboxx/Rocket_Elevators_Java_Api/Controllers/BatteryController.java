package com.codeboxx.Rocket_Elevators_Java_Api.Controllers;

import java.nio.file.FileSystemNotFoundException;
import java.util.List;
import com.codeboxx.Rocket_Elevators_Java_Api.Models.Battery;
import com.codeboxx.Rocket_Elevators_Java_Api.Repositories.BatteryRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BatteryController {

    private final BatteryRepository repository;
    BatteryController(BatteryRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/batteries")
    List<Battery> all() {
        return repository.findAll();
    }

    @GetMapping("/batteries/{id}")
    Battery one(@PathVariable int id) {

        return repository.findById(id)
                .orElseThrow(FileSystemNotFoundException::new)
;    }


}