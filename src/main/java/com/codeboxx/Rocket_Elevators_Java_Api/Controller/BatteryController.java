package com.codeboxx.Rocket_Elevators_Java_Api.Controller;

import java.nio.file.FileSystemNotFoundException;
import java.util.List;
import com.codeboxx.Rocket_Elevators_Java_Api.Models.Battery;
import com.codeboxx.Rocket_Elevators_Java_Api.Repository.BatteryRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BatteryController {

    private final BatteryRepository repository;
    BatteryController(BatteryRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/battery")
    List<Battery> all() {
        return repository.findAll();
    }

    @GetMapping("/battery/{id}")
    Battery one(@PathVariable int id) {

        return repository.findById(id)
                .orElseThrow(() -> new FileSystemNotFoundException())
;    }


}
