package com.codeboxx.Rocket_Elevators_Java_Api.Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "columns")
public class Column {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; //private = restricted access
    private int floors; //private = restricted access
    private String status; //private = restricted access
    private String information; //private = restricted access
    private String notes; //private = restricted access

}
