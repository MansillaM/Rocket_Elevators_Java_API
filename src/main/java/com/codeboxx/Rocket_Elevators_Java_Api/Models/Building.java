package com.codeboxx.Rocket_Elevators_Java_Api.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "buildings")
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; //private = restricted access
    @JsonIgnore
    private int customer_id; //private = restrcited access
    private int address_id; //private = restricted access
    private String name; //private = restricted access
    private String email; //private = restricted access
    private String phone; //private = restricted access
    private String tech_name; //private = restricted access
    private String tech_email; //private = restricted access
    private String tech_phone; //private = restricted access

}
