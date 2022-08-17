package com.codeboxx.Rocket_Elevators_Java_Api.Repository;

import com.codeboxx.Rocket_Elevators_Java_Api.Models.Column;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColumnRepository extends JpaRepository<Column, Integer> {

}
