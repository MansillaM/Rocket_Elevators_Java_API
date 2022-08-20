package com.codeboxx.Rocket_Elevators_Java_Api.Repositories;

import com.codeboxx.Rocket_Elevators_Java_Api.Models.Battery;
import com.codeboxx.Rocket_Elevators_Java_Api.Models.Building;
import com.codeboxx.Rocket_Elevators_Java_Api.Models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Integer> {

    //Sql query for getting current user info
    @Query(("SELECT bat FROM Battery bat WHERE bat.building_id = :id"))
    List<Battery> findByBatteryId(int id);

    @Query(("SELECT cus FROM Customer cus WHERE cus.user_id = :id"))
    List<Customer> findByUser_Id(int id);
    @Query(("SELECT bui FROM Building bui WHERE bui.customer_id = :id"))
    List<Building> findByCustomer_Id(int id);
}
