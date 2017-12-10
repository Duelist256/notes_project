package com.epam.enote.persistence;

import com.epam.enote.model.Notebook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotebookRepository extends JpaRepository<Notebook, Integer> {
}
