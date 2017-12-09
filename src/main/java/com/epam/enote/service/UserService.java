package com.epam.enote.service;

import com.epam.enote.model.User;

import java.util.List;

public interface UserService {
    User addUser(User user);

    User updateUser(User user);

    User getUserById(int id);

    void deleteUser(User user);

    List<User> findAllUsers();
}
