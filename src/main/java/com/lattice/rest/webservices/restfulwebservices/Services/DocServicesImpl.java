package com.lattice.rest.webservices.restfulwebservices.Services;

import com.lattice.rest.webservices.restfulwebservices.Entities.City;
import com.lattice.rest.webservices.restfulwebservices.Entities.Doctor;
import com.lattice.rest.webservices.restfulwebservices.Entities.Patient;
import com.lattice.rest.webservices.restfulwebservices.Entities.Speciality;
import com.lattice.rest.webservices.restfulwebservices.Repositories.DocRepository;
import com.lattice.rest.webservices.restfulwebservices.Repositories.PRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class DocServicesImpl implements DocServices {

    @Autowired
    private DocRepository doctorRepository;

    @Autowired
    private PRepository patientRepository;

    @Override
    public void addDoctor( Doctor doctor) {
            doctorRepository.save(doctor);
    }

    @Override
    public String removeDoctor(Long doctorId) {
        try {
            doctorRepository.findById(doctorId).get();
            doctorRepository.deleteById(doctorId);
            return "Doctor deleted successfully";
        }catch (Exception e){
            return "No doctor found";
        }
    }

    @Override
    public List<Doctor> getSuggestedDoctors(Long patientId) {
        Optional<Patient> optionalPatient = patientRepository.findById(patientId);
        if (optionalPatient.isPresent()) {
            Patient patient = optionalPatient.get();

            City city=City.fromCity(String.valueOf(patient.getCity()));
            Speciality speciality=Speciality.fromSymptom(String.valueOf(patient.getSymptom()));

            if(city==null && speciality!=null){
                return Collections.singletonList(new Doctor("We are still waiting to expand to your location"));
            }
            else{
                List<Doctor> suggestedDoctors = doctorRepository.findByCityAndSpeciality(city, speciality);
                if (suggestedDoctors.isEmpty())
                    return Collections.singletonList(new Doctor("Theirs no doctor available for your Symptom"));
                else return suggestedDoctors;
            }



        } else {
            return Collections.singletonList(new Doctor( "No Patient Found"));
        }
    }
}
