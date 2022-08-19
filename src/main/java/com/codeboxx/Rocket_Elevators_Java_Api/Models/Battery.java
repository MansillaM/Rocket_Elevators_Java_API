package com.codeboxx.Rocket_Elevators_Java_Api.Models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate; //import LocalDate

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "batteries")
public class Battery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; //private = restricted access
    @JsonIgnore
    private int building_id; //private = restricted access
    private String building_type; //private = restricted access
    private String status; //private = restricted access
    private LocalDate comm_date; //private = restricted access
    private LocalDate inspec_date; //private = restricted access
    private int certificate; //private = restricted access
    private String information; //private = restricted access
    private String notes; //private = restricted access

}
