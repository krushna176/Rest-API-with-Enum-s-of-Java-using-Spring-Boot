package com.lattice.rest.webservices.restfulwebservices.Services;

import com.lattice.rest.webservices.restfulwebservices.Entities.Doctor;

import java.util.List;

public interface DocServices {
    void addDoctor(Doctor doctor);

    String removeDoctor(Long doctorId);

    List<Doctor> getSuggestedDoctors(Long patientId);
}
