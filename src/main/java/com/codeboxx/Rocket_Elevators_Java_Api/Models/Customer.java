package com.codeboxx.Rocket_Elevators_Java_Api.Models;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate; //import LocalDate class
import java.time.LocalDateTime; //import LocalDateTime class

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; //private = restricted access
    private int user_id;
    private LocalDate creation_date; //private = restricted access
    private String company_name; //private = restricted access
    private String name; //private = restricted access
    private String phone; //private = restricted access
    private String email; //private = restricted access
    private String description; //private = restricted access
    private String auth_name; //private = restricted access
    private String auth_phone; //private = restricted access
    private String mangr_email; //private = restricted access
    private LocalDateTime created_at; //private = restricted access
    private LocalDateTime updated_at; //private = restricted access

}
