package com.codeboxx.Rocket_Elevators_Java_Api.Repositories;

import com.codeboxx.Rocket_Elevators_Java_Api.Models.Elevator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElevatorRepository extends JpaRepository<Elevator, Integer> {
}
