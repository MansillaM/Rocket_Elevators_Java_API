package com.codeboxx.Rocket_Elevators_Java_Api.Models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate; //import LocalDate class

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "elevators")
public class Elevator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; //private = restricted access
    @JsonIgnore
    private int column_id;//private = restricted access
    private String serial_number; //private = restricted access
    private String model; //private = restricted access
    private String elevator_status; //private = restricted access
    private LocalDate comm_date; //private = restricted access
    private LocalDate inspec_date; //private = restricted access
    private int certificate; //private = restricted access
    private String information; //private = restricted access
    private String notes; //private = restricted access

}
