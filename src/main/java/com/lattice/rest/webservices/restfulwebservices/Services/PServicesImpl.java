package com.lattice.rest.webservices.restfulwebservices.Services;

import com.lattice.rest.webservices.restfulwebservices.Entities.Patient;
import com.lattice.rest.webservices.restfulwebservices.Repositories.PRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PServicesImpl implements PServices{
    @Autowired
    private PRepository patientRepository;

    @Override
    public void addPatient(Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    public String removePatient(Long patientId) {

        try {
            patientRepository.findById(patientId).get();
            patientRepository.deleteById(patientId);
            return "Patient deleted successfully";
        }catch (Exception e){
            return "No Patient found";
        }
    }
}
