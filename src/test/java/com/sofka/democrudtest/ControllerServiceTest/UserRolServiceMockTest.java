package com.sofka.democrudtest.ControllerServiceTest;

import com.sofka.democrudtest.repositories.UserRolRepository;
import com.sofka.democrudtest.services.UserRolService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserRolServiceMockTest {
    @MockBean
    UserRolRepository userRolRepository;

    @Autowired
    UserRolService userRolService;

    @Test
    public void testUserRolMock(){
        when(userRolRepository.findAll()).thenReturn(new ArrayList<>());
        assertThat(userRolService.getUserRoles()).isEmpty();
        verify(userRolRepository).findAll();
    }
}
