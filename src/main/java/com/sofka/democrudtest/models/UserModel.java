package com.sofka.democrudtest.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import java.util.LinkedHashSet;
import java.util.Set;

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

    @OneToMany(
            mappedBy = "userModel",
            fetch = FetchType.EAGER,
            targetEntity = UserRolModel.class
    )
    @JsonManagedReference
    private Set<UserRolModel> userRoles = new LinkedHashSet<>();

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getPriority() {
        return priority;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
