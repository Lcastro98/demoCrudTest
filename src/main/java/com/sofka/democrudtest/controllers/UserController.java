package com.sofka.democrudtest.controllers;

import com.sofka.democrudtest.models.UserModel;
import com.sofka.democrudtest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.ArrayList;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping()
    public ArrayList<UserModel> getUsers() {
        return userService.getUsers();
    }

    @PostMapping()
    public UserModel saveUser(@RequestBody UserModel user) {
        return this.userService.saveUser(user);
    }

    @GetMapping(path = "/{id}")
    public Optional<UserModel> getUserById(@PathVariable("id") Long id) {
        return this.userService.getById(id);
    }

    @GetMapping("/query")
    public ArrayList<UserModel> getUserByPriority(@RequestParam("priority") Integer priority) {
        return this.userService.getByPriority(priority);
    }

    @PutMapping(path = "/{id}")
    public UserModel updateById(@RequestBody UserModel user, @PathVariable("id") Long id) {
        return this.userService.updateUser(id, user);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        boolean ok = this.userService.deleteUser(id);
        if (ok) {
            return "Se eliminó el usuario con id " + id;
        } else {
            return "No pudo eliminar el usuario con id" + id;
        }
    }
}
