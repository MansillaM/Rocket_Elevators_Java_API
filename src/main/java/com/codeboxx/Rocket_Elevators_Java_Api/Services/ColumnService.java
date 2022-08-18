package com.codeboxx.Rocket_Elevators_Java_Api.Services;

import java.util.List;
import com.codeboxx.Rocket_Elevators_Java_Api.Models.Column;
import com.codeboxx.Rocket_Elevators_Java_Api.Repositories.ColumnRepository;
import org.springframework.stereotype.Service;

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
}
