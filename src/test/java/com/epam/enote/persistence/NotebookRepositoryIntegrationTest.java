package com.epam.enote.persistence;

import com.epam.enote.configuration.DatabaseConfiguration;
import com.epam.enote.model.Notebook;
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
public class NotebookRepositoryIntegrationTest {

    @Autowired
    private NotebookRepository repository;

    @Test
    public void addAndGetNotebook() throws Exception {
        Notebook notebook = Notebook.newBuilder()
                .userId(5)
                .build();
        repository.save(notebook);

        Optional<Notebook> foundUser = repository.findById(21);
        assertTrue(foundUser.isPresent());
    }

    @Test
    public void updateNotebook() throws Exception {
        Optional<Notebook> notebook = repository.findById(1);

        assertTrue(notebook.isPresent());
        Notebook gottenNotebook = notebook.get();
        int oldUserId = gottenNotebook.getUserId();

        int newUserId = 222;
        gottenNotebook.setUserId(newUserId);
        repository.save(gottenNotebook);

        Optional<Notebook> foundNotebook = repository.findById(1);

        if (foundNotebook.isPresent()) {
            assertNotEquals(oldUserId, foundNotebook.get().getUserId());
            assertEquals(newUserId, foundNotebook.get().getUserId());
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

        Optional<Notebook> foundNotebook = repository.findById(id);
        assertTrue(foundNotebook.isPresent());

        repository.delete(foundNotebook.get());

        Optional<Notebook> foundNotebook2 = repository.findById(id);
        assertFalse(foundNotebook2.isPresent());
    }

    @Test
    public void findAll() throws Exception {
        List<Notebook> foundNotebooks = repository.findAll();
        assertNotEquals(0, foundNotebooks.size());
    }
}