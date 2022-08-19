package com.codeboxx.Rocket_Elevators_Java_Api.Controllers;

import java.nio.file.FileSystemNotFoundException;
import java.util.List;

import com.codeboxx.Rocket_Elevators_Java_Api.Models.Battery;
import com.codeboxx.Rocket_Elevators_Java_Api.Models.Building;
import com.codeboxx.Rocket_Elevators_Java_Api.Services.BuildingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/buildings")
public class BuildingController {

    private final BuildingService buildingService;

    public BuildingController(BuildingService buildingService) {
        this.buildingService = buildingService;
    }

    @GetMapping("/all")
    public List<Building> getAllBuildings() {

        return buildingService.allBuildings();
    }
    @GetMapping("/{id}")
    public Building getByBuildingId(@PathVariable int id) {

        return buildingService.buildingById(id);
    }

    @GetMapping("/{id}/batteries")
    public List<Battery> getAllBatteryOfId(@PathVariable int id) {

        return buildingService.allFromBatteryId(id);
    }
}
