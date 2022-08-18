package com.codeboxx.Rocket_Elevators_Java_Api.Services;

import java.util.List;
import com.codeboxx.Rocket_Elevators_Java_Api.Models.Elevator;
import com.codeboxx.Rocket_Elevators_Java_Api.Repositories.ElevatorRepository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
@Transactional
public class ElevatorService {


    private final ElevatorRepository elevatorRepository;

    public ElevatorService(ElevatorRepository elevatorRepository) {

        this.elevatorRepository = elevatorRepository;
    }

    public List<Elevator> allElevators() {

        return elevatorRepository.findAll();
    }

    public Elevator elevatorById(int id){
        return elevatorRepository.findById(id).get();
    }
}
