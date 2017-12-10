package com.epam.enote.persistence;

import com.epam.enote.configuration.DatabaseConfiguration;
import com.epam.enote.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DatabaseConfiguration.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public class UserRepositoryIntegrationTest {

    @Autowired
    private UserRepository repository;

    @Test
    public void addAndGetUser() throws Exception {
        User user = User.newBuilder()
                .login("login1")
                .password("pwd1")
                .name("name1")
                .build();
        repository.save(user);

        Optional<User> foundUser = repository.findById(21);
        assertTrue(foundUser.isPresent());
    }

    @Test
    public void updateUser() throws Exception {
        Optional<User> user = repository.findById(1);

        assertTrue(user.isPresent());
        User gottenUser = user.get();
        String oldLogin = gottenUser.getLogin();

        String newLogin = "newTest1@test.com";
        gottenUser.setLogin(newLogin);
        repository.save(gottenUser);

        Optional<User> foundUser = repository.findById(1);

        if (foundUser.isPresent()) {
            assertNotEquals(oldLogin, foundUser.get().getLogin());
            assertEquals(newLogin, foundUser.get().getLogin());
        } else {
            fail("Found user is null");
        }
    }

    @Test
    public void deleteUser() throws Exception {
        User user = User.newBuilder()
                .login("wqeqweqw@test.com")
                .password("erwerew")
                .name("Asdas")
                .build();

        repository.save(user);

        int id = 22;

        Optional<User> foundUser = repository.findById(id);
        assertTrue(foundUser.isPresent());

        repository.delete(foundUser.get());

        Optional<User> foundUser2 = repository.findById(id);
        assertFalse(foundUser2.isPresent());
    }

    @Test
    public void findAll() throws Exception {
        List<User> foundUsers = repository.findAll();
        assertNotEquals(0, foundUsers.size());
    }
}