package com.epam.enote.persistence;

import com.epam.enote.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
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

        User foundUser = repository.findOne(21);
        assertNotNull(foundUser);
    }

    @Test
    public void updateUser() throws Exception {
        User user = repository.findOne(1);

        assertNotNull(user);
//        User gottenUser = user.get();
        String oldLogin = user.getLogin();

        String newLogin = "newTest1@test.com";
        user.setLogin(newLogin);
        repository.save(user);

        User foundUser = repository.findOne(1);

        if (foundUser != null) {
            assertNotEquals(oldLogin, foundUser.getLogin());
            assertEquals(newLogin, foundUser.getLogin());
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

        User foundUser = repository.findOne(id);
        assertNotNull(foundUser);

        repository.delete(foundUser);

        User foundUser2 = repository.findOne(id);
        assertNull(foundUser2);
    }

    @Test
    public void findAll() throws Exception {
        List<User> foundUsers = repository.findAll();
        assertNotEquals(0, foundUsers.size());
    }
}