package com.codeboxx.Rocket_Elevators_Java_Api.Services;
import com.codeboxx.Rocket_Elevators_Java_Api.Models.Battery;
import com.codeboxx.Rocket_Elevators_Java_Api.Models.Column;
import com.codeboxx.Rocket_Elevators_Java_Api.Repositories.BatteryRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import javax.transaction.Transactional;

@Service
@Transactional
public class BatteryService {

    private final BatteryRepository batteryRepository;

    public BatteryService(BatteryRepository batteryRepository) {
        this.batteryRepository = batteryRepository;
    }

    //for GET method
    public List<Battery> allBatteries() {

        return batteryRepository.findAll();
    }

    //for GET method
    public Battery batteryById(int id) {

        return batteryRepository.findById(id).get();
    }

    //for GET method
    public List<Column> allFromBatteryId(int id) {
        return batteryRepository.findByBatteryId(id);
    }

}
