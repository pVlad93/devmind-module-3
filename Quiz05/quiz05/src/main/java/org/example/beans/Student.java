package org.example.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {
    private String lastName;
    private String firstName;
    private Double grade;

    public Student() {
    }

    public Student(String lastName, String firstName, Double grade) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.grade = grade;
    }

    public String getLastName() {
        return lastName;
    }

//    @Value("${student.lastName}")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

//    @Value("${student.firstName}")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Double getGrade() {
        return grade;
    }

//    @Value("${student.grade}")
    public void setGrade(Double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", grade=" + grade +
                '}';
    }
}
