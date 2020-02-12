package com.example.myorder.entities;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "RESTAURANT")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "PHONE", nullable = false)
    @NotNull
    private String phone;

    @Column(name = "EMAIL", nullable = false)
    @Email
    private String email;

    public Integer getId() {
        return id;
    }

    public Restaurant setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Restaurant setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Restaurant setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Restaurant setEmail(String email) {
        this.email = email;
        return this;
    }
}
