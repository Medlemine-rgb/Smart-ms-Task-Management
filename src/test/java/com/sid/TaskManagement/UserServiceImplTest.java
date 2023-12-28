package com.sid.TaskManagement;

import com.sid.TaskManagement.entities.AppUser;
import com.sid.TaskManagement.repository.AppUserRepository;
import com.sid.TaskManagement.repository.RoleRepository;
import com.sid.TaskManagement.services.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private AppUserRepository appUserRepository;

    @Mock
    private RoleRepository roleRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddUser() {
        // Arrange
        AppUser user = new AppUser();
        user.setUsername("testUser");
        user.setPassword("password");

        // Mocking RoleRepository
//        Role role = Role.builder().id(1).build();
//        when(roleRepository.findById(1)).thenReturn(Optional.of(role));

        // Mocking PasswordEncoder
        when(passwordEncoder.encode(user.getPassword())).thenReturn("encodedPassword");

        // Act
        userService.addUser(user);

        // Assert
        assertEquals("encodedPassword", user.getPassword());
//        assertEquals(role, user.getRole());
        verify(roleRepository, times(1)).findById(1);
        verify(passwordEncoder, times(1)).encode("password");
        verify(appUserRepository, times(1)).save(user);
    }
}
