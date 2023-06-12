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
    private Gender gender;

    public Student(String firstName, String lastName, String email, String password, Gender gender) {
            this.id = counter++;
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.password = password;
            this.gender = gender;

    }

    public static long getCounter() {
        return counter;
    }

    public static void setCounter(long counter) {
        Student.counter = counter;
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
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
