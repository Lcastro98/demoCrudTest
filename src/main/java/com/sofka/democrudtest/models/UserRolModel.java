package com.sofka.democrudtest.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "user_rol")
public class UserRolModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private String rol;

    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    private UserModel userModel;

    public Long getId() {
        return id;
    }

    public String getRol() {
        return rol;
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }

    public UserRolModel(Long id, String rol, UserModel userModel) {
        this.id = id;
        this.rol = rol;
        this.userModel = userModel;
    }

    public UserRolModel() {

    }
}