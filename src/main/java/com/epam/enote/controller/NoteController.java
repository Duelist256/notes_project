package com.epam.enote.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/api/note")
public class NoteController {

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<String> addNote() {
		return new ResponseEntity<>("Add Note", HttpStatus.OK);
	}

	@RequestMapping(value = "/{noteId}", method = RequestMethod.GET)
	public ResponseEntity<String> readNote(@PathVariable String noteId) {
		return new ResponseEntity<>("Read Note: " + noteId, HttpStatus.OK);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<String> updateNote() {
		return new ResponseEntity<>("Update Note", HttpStatus.OK);
	}

	@RequestMapping(value = "/delete/{noteId}", method = RequestMethod.GET)
	public ResponseEntity<String> deleteNote(@PathVariable String noteId) {
		return new ResponseEntity<>("Delete Note: " + noteId, HttpStatus.OK);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<String> getAllNotes() {
		return new ResponseEntity<>("Get All Notes", HttpStatus.OK);
	}
}
