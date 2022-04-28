package com.sofka.democrudtest.ServicesTest;

import com.sofka.democrudtest.models.UserModel;
import com.sofka.democrudtest.models.UserRolModel;
import com.sofka.democrudtest.repositories.UserRolRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class UserRolServiceTest {
    @Autowired
    UserRolRepository userRolRepository;

    @Test
    public void testSaveUserRol(){
        UserRolModel userRolModel=new UserRolModel(1L, "Vendedor", new UserModel("Camila", "cami@gmail.com", 50));
        UserRolModel userRolModelSaved = userRolRepository.save(userRolModel);
        assertNotNull(userRolModelSaved);
    }

    @Test
    public void testSearchUserRolById(){
        Long idSearched=1L;
        Optional<UserRolModel> userRolModelSearched=userRolRepository.findById(idSearched);
        assertThat(userRolModelSearched.get().getId()).isEqualTo(idSearched);
    }

    @Test
    public void testListUserRol(){
        List<UserRolModel> userRolModelList=(List<UserRolModel>) userRolRepository.findAll();
        assertThat(userRolModelList).size().isGreaterThan(0);
    }
}
