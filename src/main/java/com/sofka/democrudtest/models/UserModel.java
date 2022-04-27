package com.sofka.democrudtest.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name = "user")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private String name;
    private String email;
    private Integer priority;

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getPrioridad() {
        return priority;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return name;
    }

    public void setNombre(String nombre) {
        this.name = nombre;
    }

    public String getEmail() {
        return email;
    }

    public UserModel(String name, String email, Integer priority) {
        this.name = name;
        this.email = email;
        this.priority = priority;
    }

    public UserModel() {

    }

    public void setEmail(String email) {
        this.email = email;
    }

}
