package com.lattice.rest.webservices.restfulwebservices.Services;

import com.lattice.rest.webservices.restfulwebservices.Entities.Patient;

public interface PServices {

    void addPatient(Patient patient);

    String removePatient(Long patientId);
}
