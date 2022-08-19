package com.codeboxx.Rocket_Elevators_Java_Api.Services;
import com.codeboxx.Rocket_Elevators_Java_Api.Models.Battery;
import com.codeboxx.Rocket_Elevators_Java_Api.Models.Building;
import com.codeboxx.Rocket_Elevators_Java_Api.Repositories.BuildingRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BuildingService {

    private final BuildingRepository buildingRepository;


    public BuildingService(BuildingRepository buildingRepository) {
        this.buildingRepository = buildingRepository;
    }

    public List<Building> allBuildings() {

        return buildingRepository.findAll();
    }

    public Building buildingById(int id) {

        return buildingRepository.findById(id).get();
    }

    public List<Battery> allFromBatteryId(int id) {
        return buildingRepository.findByBatteryId(id);
    }
}
