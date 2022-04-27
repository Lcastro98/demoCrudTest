package com.sofka.democrudtest.ControllerServiceTest;

import com.sofka.democrudtest.controllers.UserController;
import com.sofka.democrudtest.models.UserModel;
import com.sofka.democrudtest.repositories.UserRepository;
import com.sofka.democrudtest.services.UserService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserServiceMockTest {

    @MockBean
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Test
    public void testUserMock(){
        when(userRepository.findAll()).thenReturn(new ArrayList<>());
        assertThat(userService.getUsers()).isEmpty();
        verify(userRepository).findAll();
    }
}
