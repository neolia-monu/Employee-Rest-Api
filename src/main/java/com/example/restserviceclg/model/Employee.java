package com.example.restserviceclg.model;

import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name="employee")
@RequiredArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="first_name", nullable = false)
    private String firstName;

    @Column(name = "gender")
    private Character gender;

    @Column(name = "email")
    private String email;

    @Column(name = "age", nullable = false)
    private Integer age;

    @Column(name = "Date_created")
    private Instant dateCreated;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Instant getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Instant dateCreated) {
        this.dateCreated = dateCreated;
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

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
