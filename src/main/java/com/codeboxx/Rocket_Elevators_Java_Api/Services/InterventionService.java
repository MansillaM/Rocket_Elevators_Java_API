package com.codeboxx.Rocket_Elevators_Java_Api.Services;

import java.util.List;

import com.codeboxx.Rocket_Elevators_Java_Api.Models.Intervention;
import com.codeboxx.Rocket_Elevators_Java_Api.Repositories.InterventionRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class InterventionService {

    private final InterventionRepository interventionRepository;

    public InterventionService(InterventionRepository interventionRepository) {
        this.interventionRepository = interventionRepository;
    }

    //for GET method
    public List<Intervention> allInterventions() {
        return interventionRepository.findAll();
    }

    //for GET method
    public Intervention interventionById(int id){
        return interventionRepository.findById(id).get();
    }

    //for POST method
    public void createIntervention(Intervention newIntervention) {
        interventionRepository.save(newIntervention);
    }

    //for DELETE method
    public void deleteIntervention(int id) {
        interventionRepository.deleteById(id);
    }

    //for PATCH method
    public Intervention replaceIntervention(Intervention updateIntervention, int id) {
       return interventionRepository.findById(id)
               .map(intervention -> {
                   intervention.setStatus(updateIntervention.getStatus());
                   intervention.setResult(updateIntervention.getResult());
                   return interventionRepository.save(intervention);
               })
               .orElseGet(() -> {
                   updateIntervention.setId(id);
                   return interventionRepository.save(updateIntervention);
               });
    }


}
