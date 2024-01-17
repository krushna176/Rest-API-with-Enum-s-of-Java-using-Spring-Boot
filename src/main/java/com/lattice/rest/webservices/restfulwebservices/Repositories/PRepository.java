package com.lattice.rest.webservices.restfulwebservices.Repositories;
import com.lattice.rest.webservices.restfulwebservices.Entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PRepository extends JpaRepository<Patient, Long> {
}
