package com.codeboxx.Rocket_Elevators_Java_Api.Controllers;

import java.nio.file.FileSystemNotFoundException;
import java.util.List;
import com.codeboxx.Rocket_Elevators_Java_Api.Models.Column;
import com.codeboxx.Rocket_Elevators_Java_Api.Repository.ColumnRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ColumnController {

    private final ColumnRepository repository;
    ColumnController(ColumnRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/columns")
    List<Column> all() {
        return repository.findAll();
    }

    @GetMapping("/columns/{id}")
    Column one(@PathVariable int id) {

        return repository.findById(id)
                .orElseThrow(() -> new FileSystemNotFoundException());
    }
}
