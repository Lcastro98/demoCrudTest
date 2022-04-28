package com.sofka.democrudtest.controllers;

import com.sofka.democrudtest.models.UserRolModel;
import com.sofka.democrudtest.services.UserRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.ArrayList;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/user/roles")
public class UserRolController {
    @Autowired
    UserRolService userRolService;

    @GetMapping()
    public ArrayList<UserRolModel> getUserRoles() {
        return userRolService.getUserRoles();
    }

    @PostMapping()
    public UserRolModel saveUserRol(@RequestBody UserRolModel rol) {
        return this.userRolService.saveUserRol(rol);
    }

    @GetMapping(path = "/{id}")
    public Optional<UserRolModel> getUserRolById(@PathVariable("id") Long id) {
        return this.userRolService.getById(id);
    }

    @PutMapping(path = "/{id}")
    public UserRolModel updateById(@RequestBody UserRolModel rol, @PathVariable("id") Long id) {
        return this.userRolService.updateUserRol(id, rol);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        boolean ok = this.userRolService.deleteUserRol(id);
        if (ok) {
            return "Se eliminó el rol con id " + id;
        } else {
            return "No pudo eliminar el rol con id" + id;
        }
    }
}
