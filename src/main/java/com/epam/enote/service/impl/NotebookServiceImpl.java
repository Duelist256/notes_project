package com.epam.enote.service.impl;

import com.epam.enote.model.Notebook;
import com.epam.enote.persistence.NotebookRepository;
import com.epam.enote.service.NotebookService;

import java.util.List;

public class NotebookServiceImpl implements NotebookService {

    private final NotebookRepository notebookRepository;

    public NotebookServiceImpl(NotebookRepository notebookRepository) {
        this.notebookRepository = notebookRepository;
    }

    @Override
    public void addNotebook(Notebook notebook) {
        throw new UnsupportedOperationException("Method isn't implemented yet");
    }

    @Override
    public void updateNotebook(Notebook notebook) {
        throw new UnsupportedOperationException("Method isn't implemented yet");
    }

    @Override
    public Notebook findNotebookById(int id) {
        throw new UnsupportedOperationException("Method isn't implemented yet");
    }

    @Override
    public void deleteNotebook(Notebook notebook) {
        throw new UnsupportedOperationException("Method isn't implemented yet");
    }

    @Override
    public List<Notebook> findAllNotebooks() {
        throw new UnsupportedOperationException("Method isn't implemented yet");
    }
}
