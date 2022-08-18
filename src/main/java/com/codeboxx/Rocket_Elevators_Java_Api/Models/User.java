package com.codeboxx.Rocket_Elevators_Java_Api.Models;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime; //import LocalDateTime class
import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; //private = restricted access
    private String email; //private = restricted access
    private LocalDateTime created_at; //private = restricted access
    private LocalDateTime updated_at; //private = restricted access

}
