package com.codeboxx.Rocket_Elevators_Java_Api.Repositories;

import com.codeboxx.Rocket_Elevators_Java_Api.Models.Intervention;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterventionRepository extends JpaRepository<Intervention, Integer> {
}
