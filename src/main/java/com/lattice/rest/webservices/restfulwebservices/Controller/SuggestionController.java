package com.lattice.rest.webservices.restfulwebservices.Controller;

import com.lattice.rest.webservices.restfulwebservices.Entities.Doctor;
import com.lattice.rest.webservices.restfulwebservices.Services.DocServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/suggestions")
public class SuggestionController {
    @Autowired
    private DocServices doctorService;

    @GetMapping("/getDoctors/{patientId}")
    public ResponseEntity<List<Doctor>> getSuggestedDoctors(@PathVariable Long patientId) {
        List<Doctor> suggestedDoctors = doctorService.getSuggestedDoctors(patientId);
        return ResponseEntity.ok(suggestedDoctors);


    }
}
