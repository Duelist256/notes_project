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
    public void test() throws Exception {
        User user = new User();
        user.setId(1);
        user.setLogin("login1");
        user.setPassword("pwd1");
        user.setName("name1");

        repository.save(user);

        User result = repository.getById(1);

        assertThat(user.equals(result), is(true));

        User user2 = new User();
        user.setId(12);
        user.setLogin("ew");
        user.setPassword("wer");
        user.setName("name1");
        repository.save(user2);
    }
}