package com.codeboxx.Rocket_Elevators_Java_Api.Controllers;

import java.nio.file.FileSystemNotFoundException;
import java.security.Principal;
import java.util.Base64;
import java.util.List;

import com.codeboxx.Rocket_Elevators_Java_Api.Models.Battery;
import com.codeboxx.Rocket_Elevators_Java_Api.Models.Building;
import com.codeboxx.Rocket_Elevators_Java_Api.Models.Customer;
import com.codeboxx.Rocket_Elevators_Java_Api.Repositories.BuildingRepository;
import com.codeboxx.Rocket_Elevators_Java_Api.Services.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/buildings")
public class BuildingController {

    private final BuildingRepository buildingRepository;
    private final BuildingService buildingService;

    public BuildingController(BuildingService buildingService, BuildingRepository buildingRepository) {
        this.buildingService = buildingService;
        this.buildingRepository = buildingRepository;
    }

    //for GET method
    @GetMapping("/all")
    public List<Building> getAllBuildings() {

        return buildingService.allBuildings();
    }

    //for GET method
    @GetMapping("/{id}")
    public Building getByBuildingId(@PathVariable int id) {

        return buildingService.buildingById(id);
    }

    //for GET method
    @GetMapping("/{id}/batteries")
    public List<Battery> getAllBatteryOfId(@PathVariable int id) {

        return buildingService.allFromBatteryId(id);
    }

    //for GET method
    @GetMapping("/current")
    List<Building> user(HttpServletRequest request) {
        String encodedUser = request.getHeader("Authorization").split("\\.")[1];
        byte[] decodedBytes = Base64.getDecoder().decode(encodedUser);
        String decodedUser = new String(decodedBytes);
        Integer decodedUser_Id = Integer.parseInt(decodedUser.split("(:)|(\")|(,)")[4]);
        Customer customer = buildingRepository.findByUser_Id(decodedUser_Id).get(0);
        return buildingRepository.findByCustomer_Id(customer.getId());
    }
}
