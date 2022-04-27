package com.sofka.democrudtest.ServicesTest;


import com.sofka.democrudtest.models.UserModel;
import com.sofka.democrudtest.repositories.UserRepository;
import com.sofka.democrudtest.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static  org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class UserServiceTest {
    @Autowired
    UserRepository userRepository;

    @Test
    public void testSaveUser(){
        UserModel userModel=new UserModel("aquaman","aqua@gmail.com",99);
        UserModel userModelSaved = userRepository.save(userModel);
        assertNotNull(userModelSaved);
    }

    @Test
    public void testSearchUserById(){
        Long idSearched=1L;
        Optional<UserModel> userModelSearched=userRepository.findById(idSearched);
        assertThat(userModelSearched.get().getId()).isEqualTo(idSearched);
    }

    @Test
    public void testListUser(){
        List<UserModel> userModelList=(List<UserModel>) userRepository.findAll();
        assertThat(userModelList).size().isGreaterThan(0);
    }
}
