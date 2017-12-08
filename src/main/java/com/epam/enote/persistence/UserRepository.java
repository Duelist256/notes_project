package com.epam.enote.persistence;

import com.epam.enote.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    public User save(User user);
    public User getById(int id);
}
