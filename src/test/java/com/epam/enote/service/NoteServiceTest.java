package com.epam.enote.service;

import com.epam.enote.model.Note;
import com.epam.enote.persistence.NoteRepository;
import com.epam.enote.service.impl.NoteServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class NoteServiceTest {

    @Mock
    private NoteRepository noteRepository;

    @InjectMocks
    private NoteServiceImpl noteService;
    
    @Test
    public void addNote() throws Exception {

        Note note = Note.newBuilder()
                .text("adasdasdqwrrq")
                .notebookId(15)
                .build();

        doReturn(note).when(noteRepository).save(note);
        noteService.addNote(note);
        verify(noteRepository, times(1)).save(note);
    }

    @Test
    public void updateNote() throws Exception {

        Note note = Note.newBuilder()
                .id(1)
                .text("zzxxczxcz")
                .notebookId(15)
                .build();
        doReturn(note).when(noteRepository).save(note);

        noteService.updateNote(note);
        verify(noteRepository, times(1)).save(note);
    }

    @Test
    public void findNoteById() throws Exception {
        doReturn(Note.newBuilder().build()).when(noteRepository).findOne(anyInt());
        int id = 2;
        noteService.findNoteById(id);
        verify(noteRepository, times(1)).findOne(id);
    }

    @Test
    public void deleteNote() throws Exception {
        Note note = Note.newBuilder().build();
        doNothing().when(noteRepository).delete(note);
        noteService.deleteNote(note);
        verify(noteRepository, times(1)).delete(note);
    }

    @Test
    public void findAllNotes() throws Exception {
        doReturn(new ArrayList<>()).when(noteRepository).findAll();
        noteService.findAllNotes();
        verify(noteRepository, times(1)).findAll();
    }

}