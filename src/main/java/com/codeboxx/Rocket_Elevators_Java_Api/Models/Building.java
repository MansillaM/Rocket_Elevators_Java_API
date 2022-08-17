package com.codeboxx.Rocket_Elevators_Java_Api.Models;

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
    private int address_id; //private = restricted access
    private String name; //private = restricted access
    private String email; //private = restricted access
    private String phone; //private = restricted access
    private String tech_name; //private = restricted access
    private String tech_email; //private = restricted access
    private String tech_phone; //private = restricted access

}
