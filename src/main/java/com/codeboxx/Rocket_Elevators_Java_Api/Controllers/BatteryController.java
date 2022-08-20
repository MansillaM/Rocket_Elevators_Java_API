package com.codeboxx.Rocket_Elevators_Java_Api.Controllers;

import java.nio.file.FileSystemNotFoundException;
import java.util.List;
import com.codeboxx.Rocket_Elevators_Java_Api.Models.Battery;
import com.codeboxx.Rocket_Elevators_Java_Api.Models.Column;
import com.codeboxx.Rocket_Elevators_Java_Api.Services.BatteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/batteries")
public class BatteryController {

    private final BatteryService batteryService;

    public BatteryController(BatteryService batteryService) {
        this.batteryService = batteryService;
    }

    //for GET method
    @GetMapping("/all")
    public List<Battery> getAllBatteries() {

        return batteryService.allBatteries();
    }

    //for GET method
    @GetMapping("/{id}")
    public Battery getByBatteryId(@PathVariable int id) {

        return batteryService.batteryById(id);
    }

    //for GET method
    @GetMapping("/{id}/columns")
    public List<Column> getAllColumnOfId(@PathVariable int id) {

        return batteryService.allFromBatteryId(id);
    }

}
