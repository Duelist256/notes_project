package com.epam.enote.persistence;

import com.epam.enote.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User save(User user);

    User getById(int id);

    void delete(User user);

    List<User> findAll();
}
