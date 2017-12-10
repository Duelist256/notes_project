package com.epam.enote.service.impl;

import com.epam.enote.exception.NoSuchNoteException;
import com.epam.enote.model.Note;
import com.epam.enote.persistence.NoteRepository;
import com.epam.enote.service.NoteService;

import java.util.List;
import java.util.Optional;

public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;

    public NoteServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public void addNote(Note note) {
        noteRepository.save(note);
    }

    @Override
    public void updateNote(Note note) {
        noteRepository.save(note);
    }

    @Override
    public Note findNoteById(int id) {
        Optional<Note> note = noteRepository.findById(id);
        return note.map(o -> note.get()).orElseThrow(() -> new NoSuchNoteException("Note not found!"));
    }

    @Override
    public void deleteNote(Note note) {
        noteRepository.delete(note);
    }

    @Override
    public List<Note> findAllNotes() {
        return noteRepository.findAll();
    }
}
