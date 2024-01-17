package com.lattice.rest.webservices.restfulwebservices.Entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;


@Entity
@Table(name = "doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @NotEmpty(message = "Name should be at least 3 characters")
    @Size(min = 3)
    private String name;

    @Email(message = "Invalid email address")
    private String email;

    @Pattern(regexp = "^\\d{10}$", message = "Phone number should be at least 10 digits")
    private String phoneNumber;
    @NotNull(message = "City can't be null")
    @Enumerated(EnumType.STRING)
    private City city;

    @NotNull(message = "Speciality can't be null")
    @Enumerated(EnumType.STRING)
    private Speciality speciality;

    public Doctor() {

    }

    public Doctor(Long id, String name, String email, String phoneNumber, City city, Speciality speciality) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.speciality = speciality;

    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", city=" + city +
                ", speciality=" + speciality +
                '}';
    }

    public Doctor(String s) {
        errorMessage=s;
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

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }
}
