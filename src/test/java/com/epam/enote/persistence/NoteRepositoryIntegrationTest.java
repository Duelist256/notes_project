package com.epam.enote.persistence;

import com.epam.enote.configuration.DatabaseConfiguration;
import com.epam.enote.model.Note;
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
public class NoteRepositoryIntegrationTest {

    @Autowired
    private NoteRepository repository;

    @Test
    public void addAndGetNote() throws Exception {
        Note note = Note.newBuilder()
                .text("ASDsadasdasdasdasd")
                .notebookId(5)
                .build();
        repository.save(note);

        Optional<Note> foundUser = repository.findById(21);
        assertTrue(foundUser.isPresent());
    }

    @Test
    public void updateNote() throws Exception {
        Optional<Note> note = repository.findById(1);

        assertTrue(note.isPresent());
        Note gottenNote = note.get();

        int oldNotebookId = gottenNote.getNotebookId();

        int newNotebookId = 222;
        gottenNote.setNotebookId(newNotebookId);
        repository.save(gottenNote);

        Optional<Note> foundNote = repository.findById(1);

        if (foundNote.isPresent()) {
            assertNotEquals(oldNotebookId, foundNote.get().getNotebookId());
            assertEquals(newNotebookId, foundNote.get().getNotebookId());
        } else {
            fail("Found note is null");
        }
    }

    @Test
    public void deleteUser() throws Exception {
        Note note = Note.newBuilder()
                .text("ewrwerwsdsas")
                .notebookId(15)
                .build();

        repository.save(note);

        int id = 22;

        Optional<Note> foundNote = repository.findById(id);
        assertTrue(foundNote.isPresent());

        repository.delete(foundNote.get());

        Optional<Note> foundNote2 = repository.findById(id);
        assertFalse(foundNote2.isPresent());
    }

    @Test
    public void findAll() throws Exception {
        List<Note> foundNotes = repository.findAll();
        assertNotEquals(0, foundNotes.size());
    }
}