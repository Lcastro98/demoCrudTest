package com.sofka.democrudtest.services;

import com.sofka.democrudtest.models.UserModel;
import com.sofka.democrudtest.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public ArrayList<UserModel> getUsers(){
        return (ArrayList<UserModel>) userRepository.findAll();
    }

    public UserModel saveUser(UserModel user){
        return userRepository.save(user);
    }

    public Optional<UserModel> getById(Long id){
        return userRepository.findById(id);
    }


    public ArrayList<UserModel>  getByPriority(Integer priority) {
        return userRepository.findByPriority(priority);
    }

    public UserModel updateUser(Long id, UserModel user) {
        user.setId(id);
        return userRepository.save(user);
    }

    public boolean deleteUser(Long id) {
        try{
            userRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}
