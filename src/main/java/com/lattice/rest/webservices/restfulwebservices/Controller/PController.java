package com.lattice.rest.webservices.restfulwebservices.Controller;

import com.lattice.rest.webservices.restfulwebservices.Entities.Patient;
import com.lattice.rest.webservices.restfulwebservices.Services.PServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/patients")
public class PController {
    @Autowired
    private PServices patientService;

    @PostMapping("/add")
    public ResponseEntity<String> addPatient(@RequestBody @Valid Patient patient) {
        patientService.addPatient(patient);
        return ResponseEntity.ok("Patient added successfully");
    }

    @DeleteMapping("/remove/{patientId}")
    public String removePatient(@PathVariable Long patientId) {

        return patientService.removePatient(patientId);
    }
}
