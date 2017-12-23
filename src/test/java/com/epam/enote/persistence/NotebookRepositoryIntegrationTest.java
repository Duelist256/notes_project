package com.epam.enote.persistence;

import com.epam.enote.model.Notebook;
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
public class NotebookRepositoryIntegrationTest {

    @Autowired
    private NotebookRepository repository;

    @Test
    public void addAndGetNotebook() throws Exception {
        Notebook notebook = Notebook.newBuilder()
                .userId(5)
                .build();
        repository.save(notebook);

        assertNotNull(repository.findOne(21));
    }

    @Test
    public void updateNotebook() throws Exception {
        Notebook notebook = repository.findOne(1);

        assertNotNull(notebook);
        int oldUserId = notebook.getUserId();

        int newUserId = 222;
        notebook.setUserId(newUserId);
        repository.save(notebook);

        Notebook foundNotebook = repository.findOne(1);

        if (foundNotebook != null) {
            assertNotEquals(oldUserId, foundNotebook.getUserId());
            assertEquals(newUserId, foundNotebook.getUserId());
        } else {
            fail("Found notebook is null");
        }
    }

    @Test
    public void deleteUser() throws Exception {
        Notebook notebook = Notebook.newBuilder()
                .userId(15)
                .build();

        repository.save(notebook);

        int id = 22;

        Notebook foundNotebook = repository.findOne(id);
        assertNotNull(foundNotebook);

        repository.delete(foundNotebook);


        assertNull(repository.findOne(id));
    }

    @Test
    public void findAll() throws Exception {
        List<Notebook> foundNotebooks = repository.findAll();
        assertNotEquals(0, foundNotebooks.size());
    }
}