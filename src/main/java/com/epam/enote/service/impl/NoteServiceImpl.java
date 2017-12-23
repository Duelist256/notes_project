package com.epam.enote.service.impl;

import com.epam.enote.exception.NoSuchNoteException;
import com.epam.enote.model.Note;
import com.epam.enote.persistence.NoteRepository;
import com.epam.enote.service.NoteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
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
        return noteRepository.findOne(id);
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
