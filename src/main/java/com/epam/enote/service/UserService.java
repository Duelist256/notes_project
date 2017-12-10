package com.epam.enote.service;

import com.epam.enote.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    void updateUser(User user);

    User findUserById(int id);

    void deleteUser(User user);

    List<User> findAllUsers();
}
