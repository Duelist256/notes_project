package com.epam.enote.persistence;

import com.epam.enote.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotesRepository extends JpaRepository<Note, Integer> {
}
