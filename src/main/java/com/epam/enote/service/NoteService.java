package com.epam.enote.service;

import com.epam.enote.model.Note;

import java.util.List;

public interface NoteService {
    void addNote(Note note);

    void updateNote(Note note);

    Note findNoteById(int id);

    void deleteNote(Note note);

    List<Note> findAllNotes();
}
