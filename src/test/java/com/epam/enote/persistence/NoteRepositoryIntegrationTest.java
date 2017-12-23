package com.epam.enote.persistence;

import com.epam.enote.model.Note;
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

        assertNotNull(repository.findOne(21));
    }

    @Test
    public void updateNote() throws Exception {
        Note note = repository.findOne(1);

        assertNotNull(note);
//        Note gottenNote = note.get();

        int oldNotebookId = note.getNotebookId();

        int newNotebookId = 222;
        note.setNotebookId(newNotebookId);
        repository.save(note);

        Note foundNote = repository.findOne(1);

        if (foundNote != null) {
            assertNotEquals(oldNotebookId, foundNote.getNotebookId());
            assertEquals(newNotebookId, foundNote.getNotebookId());
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

        Note foundNote = repository.findOne(id);
        assertNotNull(foundNote);

        repository.delete(foundNote);

        Note foundNote2 = repository.findOne(id);
        assertNull(foundNote2);
    }

    @Test
    public void findAll() throws Exception {
        List<Note> foundNotes = repository.findAll();
        assertNotEquals(0, foundNotes.size());
    }
}