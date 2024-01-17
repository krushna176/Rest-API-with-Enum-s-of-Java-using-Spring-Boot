package com.lattice.rest.webservices.restfulwebservices.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;


@Entity
@Table(name="patient")
public class Patient  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Name should be at least 3 characters")
    @Size(min = 3)
    private String name;

    @Email(message = "Invalid email address")
    private String email;

    @Pattern(regexp = "^\\d{10}$", message = "Phone number should be at least 10 digits")
    private String phoneNumber;
    @NotNull(message = "City can't be null")
    private String city;

    @NotNull(message = "Symptom can't be null")
    @Enumerated(EnumType.STRING)
    private Symptoms symptom;

    public Patient(Long id, String name, String email, String phoneNumber, String city, Symptoms symptom) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.symptom = symptom;
    }

    public Patient() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Symptoms getSymptom() {
        return symptom;
    }

    public void setSymptom(Symptoms symptom) {
        this.symptom = symptom;
    }
}
