package com.codeboxx.Rocket_Elevators_Java_Api.Repositories;


import com.codeboxx.Rocket_Elevators_Java_Api.Models.Battery;
import com.codeboxx.Rocket_Elevators_Java_Api.Models.Column;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BatteryRepository extends JpaRepository<Battery, Integer> {

    @Query(("SELECT column FROM Column column WHERE column.battery_id = :id"))
    List<Column> findByBatteryId(int id);
}
