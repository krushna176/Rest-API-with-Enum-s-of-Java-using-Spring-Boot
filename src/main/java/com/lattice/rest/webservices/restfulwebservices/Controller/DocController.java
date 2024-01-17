package com.lattice.rest.webservices.restfulwebservices.Controller;

import com.lattice.rest.webservices.restfulwebservices.Entities.Doctor;
import com.lattice.rest.webservices.restfulwebservices.Services.DocServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/doctors")
public class DocController {
    @Autowired
    private DocServices doctorService;

    @PostMapping("/add")
    public ResponseEntity<String> addDoctor(@RequestBody @Valid Doctor doctor) {
        doctorService.addDoctor(doctor);
        return ResponseEntity.ok("Patient added successfully");
    }

    @DeleteMapping("/remove/{doctorId}")
    public String removeDoctor(@PathVariable Long doctorId) {

        return doctorService.removeDoctor(doctorId);
    }

}
