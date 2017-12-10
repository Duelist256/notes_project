package com.epam.enote.service.impl;

import com.epam.enote.model.User;
import com.epam.enote.persistence.UserRepository;
import com.epam.enote.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void updateUser(User user) {
        throw new UnsupportedOperationException("Method isn't implemented yet");
    }

    @Override
    public User getUserById(int id) {
        throw new UnsupportedOperationException("Method isn't implemented yet");
    }

    @Override
    public void deleteUser(User user) {
        throw new UnsupportedOperationException("Method isn't implemented yet");
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
}
