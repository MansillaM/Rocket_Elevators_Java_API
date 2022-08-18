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


    @GetMapping("/all")
    public List<Intervention> getAllInterventions() {
        return interventionService.allInterventions();
    }

    @GetMapping("/{id}")
    public Intervention getById(@PathVariable int id) {

        return interventionService.interventionById(id);
    }

    @PostMapping("/new")
    public void saveIntervention(@RequestBody Intervention newIntervention) {
        interventionService.createIntervention(newIntervention);
    }

    @DeleteMapping("/delete/{id}")
    public void removeIntervention(@PathVariable int id) {
        interventionService.deleteIntervention(id);
    }

    @PatchMapping("/update/{id}")
    public Intervention patchIntervention(@RequestBody Intervention updateIntervention,@PathVariable int id) {
        return interventionService.replaceIntervention(updateIntervention, id);

    }

}
