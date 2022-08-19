package com.codeboxx.Rocket_Elevators_Java_Api.Services;

import java.time.LocalDate;
import java.util.List;
import com.codeboxx.Rocket_Elevators_Java_Api.Models.Column;
import com.codeboxx.Rocket_Elevators_Java_Api.Repositories.ColumnRepository;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.transaction.Transactional;

@Service
@Transactional
public class ColumnService {

    private final ColumnRepository columnRepository;


    public ColumnService(ColumnRepository columnRepository) {
        this.columnRepository = columnRepository;
    }

    public List<Column> allColumns() {

        return columnRepository.findAll();
    }

    public Column columnById(int id) {
        return columnRepository.findById(id).get();
    }

    @Entity
    public class Elevator {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id; //private = restricted access
        private int column_id;//private = restricted access
        private String serial_number; //private = restricted access
        private String model; //private = restricted access
        private String elevator_status; //private = restricted access
        private LocalDate comm_date; //private = restricted access
        private LocalDate inspec_date; //private = restricted access
        private int certificate; //private = restricted access
        private String information; //private = restricted access
        private String notes; //private = restricted access

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getColumn_id() {
            return column_id;
        }

        public void setColumn_id(int column_id) {
            this.column_id = column_id;
        }

    }
}
