package com.lattice.rest.webservices.restfulwebservices.Entities;

import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.web.server.ResponseStatusException;

public enum Speciality {
    ORTHOPEDIC,
    GYNECOLOGY,
    DERMATOLOGY,
    ENT;

    public static Speciality fromSymptom(String symptom) {
            switch (symptom) {
                case "ARTHRITIS":
                case "BACK PAIN":
                case "TISSUE INJURIES":
                    return ORTHOPEDIC;
                case "DYSMENORRHEA":
                    return GYNECOLOGY;
                case "SKIN INFECTION":
                case "SKIN BURN":
                    return DERMATOLOGY;
                case "EAR PAIN":
                    return ENT;
                default:
                    return null;
            }

    }
}
