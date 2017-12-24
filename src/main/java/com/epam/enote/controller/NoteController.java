package com.epam.enote.controller;

import com.epam.enote.model.Note;
import com.epam.enote.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/api/note")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<String> addNote(Note note) {
        noteService.addNote(note);
        return new ResponseEntity<>("Add Note: " + note, HttpStatus.OK);
    }

    @RequestMapping(value = "/{noteId}", method = RequestMethod.GET)
    public ResponseEntity<String> readNote(@PathVariable String noteId) {
        Note note = noteService.findNoteById(Integer.valueOf(noteId));
        return new ResponseEntity<>(note.toJson(), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<String> updateNote(Note note) {
        noteService.updateNote(note);
        return new ResponseEntity<>("Update Note: " + note, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{noteId}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteNote(@PathVariable String noteId) {
        noteService.deleteNote(Note.newBuilder().id(Integer.valueOf(noteId)).build());
        return new ResponseEntity<>("Delete Note: " + noteId, HttpStatus.OK);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<String> getAllNotes() {
        List<Note> allNotes = noteService.findAllNotes();

        // it's not good
        List<String> jsonList = allNotes.stream().map(Note::toJson).collect(Collectors.toList());
        return new ResponseEntity<>(jsonList.toString(), HttpStatus.OK);
    }


}
