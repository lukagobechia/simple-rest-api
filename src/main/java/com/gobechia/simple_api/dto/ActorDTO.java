package com.gobechia.simple_api.dto;

public class ActorDTO {
    private String firstName;
    private String lastName;

    public ActorDTO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
