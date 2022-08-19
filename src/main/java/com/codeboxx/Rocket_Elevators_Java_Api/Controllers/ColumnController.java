package com.codeboxx.Rocket_Elevators_Java_Api.Controllers;

import java.nio.file.FileSystemNotFoundException;
import java.util.ArrayList;
import java.util.List;
import com.codeboxx.Rocket_Elevators_Java_Api.Models.Column;
import com.codeboxx.Rocket_Elevators_Java_Api.Models.Elevator;
import com.codeboxx.Rocket_Elevators_Java_Api.Services.ColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/columns")
public class ColumnController {

    private final ColumnService columnService;

    public ColumnController(ColumnService columnService) {
        this.columnService = columnService;
    }

    @GetMapping("/all")
    public List<Column> getAllColumns() {

        return columnService.allColumns();
    }

    @GetMapping("/{id}")
    public Column getByColumnId(@PathVariable int id) {

        return columnService.columnById(id);
    }

    @GetMapping("/{id}/elevators")
    public List<Elevator> getAllElevatorOfId(@PathVariable int id) {

        return columnService.allFromColumnId(id);
    }
}
