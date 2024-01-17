package com.lattice.rest.webservices.restfulwebservices.Repositories;

import com.lattice.rest.webservices.restfulwebservices.Entities.City;
import com.lattice.rest.webservices.restfulwebservices.Entities.Doctor;
import com.lattice.rest.webservices.restfulwebservices.Entities.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocRepository extends JpaRepository<Doctor, Long> {
    City findByCity(City city);
    Speciality findBySpeciality(Speciality speciality);
    List<Doctor> findByCityAndSpeciality(City city, Speciality speciality);
}

