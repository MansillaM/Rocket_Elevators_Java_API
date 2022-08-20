package com.codeboxx.Rocket_Elevators_Java_Api.Models;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime; //import LocalDateTime class

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "interventions")
public class Intervention {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; //private = restricted access
    private LocalDateTime start_date; //private = restricted access
    private LocalDateTime end_date; //private = restricted access
    private String result; //private = restricted access
    private String report; //private = restricted access
    private String status; //private = restricted access
    private LocalDateTime created_at; //private = restricted access
    private LocalDateTime updated_at; //private = restricted access

}
