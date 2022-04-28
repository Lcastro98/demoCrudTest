package com.sofka.democrudtest.services;

import com.sofka.democrudtest.models.UserModel;
import com.sofka.democrudtest.models.UserRolModel;
import com.sofka.democrudtest.repositories.UserRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserRolService {

    @Autowired
    UserRolRepository userRolRepository;

    public ArrayList<UserRolModel> getUserRoles(){
        return (ArrayList<UserRolModel>) userRolRepository.findAll();
    }

    public UserRolModel saveUserRol(UserRolModel rol){
        return userRolRepository.save(rol);
    }

    public Optional<UserRolModel> getById(Long id){
        return userRolRepository.findById(id);
    }

    public UserRolModel updateUserRol(Long id, UserRolModel rol) {
        rol.setId(id);
        return userRolRepository.save(rol);
    }

    public boolean deleteUserRol(Long id) {
        try{
            userRolRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}
