package com.lattice.rest.webservices.restfulwebservices.Entities;

public enum City {
    DELHI,
    NOIDA,
    FARIDABAD;

    public static City fromCity(String city) {
        if(city.equalsIgnoreCase("Delhi")) {
            return DELHI;
        } else if (city.equalsIgnoreCase("Noida")) {
            return NOIDA;
        } else if (city.equalsIgnoreCase("Faridabad")) {
            return FARIDABAD;
        }else return null;

    }
}
