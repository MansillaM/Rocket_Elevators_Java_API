package com.codeboxx.Rocket_Elevators_Java_Api.Repositories;

import com.codeboxx.Rocket_Elevators_Java_Api.Models.Customer;
import com.codeboxx.Rocket_Elevators_Java_Api.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    //Sql query for getting current user info
    @Query(("SELECT cus FROM Customer cus WHERE cus.user_id = :id"))
    List<Customer> findByUser_Id(int id);
}
