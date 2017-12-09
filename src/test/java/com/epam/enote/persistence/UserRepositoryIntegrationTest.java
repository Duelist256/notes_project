package com.epam.enote.persistence;

import com.epam.enote.config.AppConfig;
import com.epam.enote.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public class UserRepositoryIntegrationTest {

    @Autowired
    private UserRepository repository;

    @Test
    public void addAndGetUser() throws Exception {
        User user = new User();
        int id = 21;
        user.setId(id);
        user.setLogin("login1");
        user.setPassword("pwd1");
        user.setName("name1");

        repository.save(user);

        User foundUser = repository.getById(id);
        assertNotNull(foundUser);
    }

    @Test
    public void updateUser() throws Exception {
        User user = repository.getById(1);
        String oldLogin = user.getLogin();

        String newLogin = "newTest1@test.com";
        user.setLogin(newLogin);
        repository.save(user);

        User foundUser = repository.getById(1);

        assertNotEquals(oldLogin, foundUser.getLogin());
        assertEquals(newLogin, foundUser.getLogin());
    }

    @Test
    public void deleteUser() throws Exception {
        User user = new User();
        int id = 22;
        user.setId(id);
        user.setLogin("wqeqweqw@test.com");
        user.setPassword("erwerew");
        user.setName("Asdas");

        repository.save(user);

        User foundUser = repository.getById(id);
        System.out.println(foundUser);
        assertNotNull(foundUser);

        repository.delete(foundUser);

        assertNull(repository.getById(id));
    }

    @Test
    public void findAll() throws Exception {
        List<User> foundUsers = repository.findAll();
        assertNotEquals(0, foundUsers.size());
    }
}