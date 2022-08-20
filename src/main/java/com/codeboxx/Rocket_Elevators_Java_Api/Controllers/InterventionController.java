package com.codeboxx.Rocket_Elevators_Java_Api.Controllers;

import java.util.List;

import com.codeboxx.Rocket_Elevators_Java_Api.Models.Intervention;
import com.codeboxx.Rocket_Elevators_Java_Api.Services.InterventionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/interventions")
public class InterventionController {
    private final InterventionService interventionService;

    public InterventionController(InterventionService interventionService) {
        this.interventionService = interventionService;
    }

    //for GET method
    @GetMapping("/all")
    public List<Intervention> getAllInterventions() {
        return interventionService.allInterventions();
    }

    //for GET method
    @GetMapping("/{id}")
    public Intervention getByInterventionId(@PathVariable int id) {

        return interventionService.interventionById(id);
    }

    //for GET method
    @PostMapping("/new")
    public void saveIntervention(@RequestBody Intervention newIntervention) {
        interventionService.createIntervention(newIntervention);
    }

    //for GET method
    @DeleteMapping("/delete/{id}")
    public void removeIntervention(@PathVariable int id) {
        interventionService.deleteIntervention(id);
    }

    //for GET method
    @PatchMapping("/update/{id}")
    public Intervention patchIntervention(@RequestBody Intervention updateIntervention,@PathVariable int id) {
        return interventionService.replaceIntervention(updateIntervention, id);

    }

}
