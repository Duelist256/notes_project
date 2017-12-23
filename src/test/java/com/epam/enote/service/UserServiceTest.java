package com.epam.enote.service;

import com.epam.enote.model.User;
import com.epam.enote.persistence.UserRepository;
import com.epam.enote.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void addUser() throws Exception {

        User user = User.newBuilder()
                .login("login1")
                .password("password1")
                .name("Name1")
                .build();

        doReturn(User.newBuilder().build()).when(userRepository).save(user);
        userService.addUser(user);
        verify(userRepository, times(1)).save(user);
    }

    @Test
    public void updateUser() throws Exception {

        User user = User.newBuilder()
                .login("login1")
                .password("password1")
                .name("Name1")
                .build();
        doReturn(User.newBuilder().build()).when(userRepository).save(user);

        userService.updateUser(user);
        verify(userRepository, times(1)).save(user);
    }

    @Test
    public void findUserById() throws Exception {
        doReturn(User.newBuilder().build()).when(userRepository).findOne(anyInt());
        int id = 2;
        userService.findUserById(id);
        verify(userRepository, times(1)).findOne(id);
    }

    @Test
    public void deleteUser() throws Exception {
        User user = User.newBuilder().build();
        doNothing().when(userRepository).delete(user);
        userService.deleteUser(user);
        verify(userRepository, times(1)).delete(user);
    }

    @Test
    public void findAllUsers() throws Exception {
        doReturn(new ArrayList<>()).when(userRepository).findAll();
        userService.findAllUsers();
        verify(userRepository, times(1)).findAll();
    }
}