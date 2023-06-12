package LMS.model;

import LMS.enumuration.Gender;

import java.util.List;

public class Student {
    private static long counter = 1;
    private Long id;
    private  String firstName;
    private  String lastName;
    private  String email;
    private String password;
    private String gender;

    public Student(String firstName, String lastName, String email, String password, String gender) {
        this.id = counter++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.gender = gender;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    @Override
    public String toString() {
        return "\nid: " + id +
                ", firstName: " + firstName +
                ", lastName: " + lastName +
                ", email: " + email +
                ", password: " + password +
                ", gender: " + gender;
    }
}
