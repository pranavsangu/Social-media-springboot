package com.example_web_services.restful_webservices.Versioning;

public class Name {
    private String firstName;
    private String lastName;
    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public String getFName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @Override
    public String toString() {
        return "Nam [firstName=" + firstName + ", lastName=" + lastName + "]";
    }
    


}
