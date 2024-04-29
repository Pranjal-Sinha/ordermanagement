package com.cloudbees.demo.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
    private String firstName;
    private String lastName;
    private String email;
    private String details;

    public Order(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Order{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}