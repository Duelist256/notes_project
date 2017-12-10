package com.epam.enote.service.impl;

import com.epam.enote.exception.NoSuchNotebookException;
import com.epam.enote.model.Notebook;
import com.epam.enote.persistence.NotebookRepository;
import com.epam.enote.service.NotebookService;

import java.util.List;
import java.util.Optional;

public class NotebookServiceImpl implements NotebookService {

    private final NotebookRepository notebookRepository;

    public NotebookServiceImpl(NotebookRepository notebookRepository) {
        this.notebookRepository = notebookRepository;
    }

    @Override
    public void addNotebook(Notebook notebook) {
        notebookRepository.save(notebook);
    }

    @Override
    public void updateNotebook(Notebook notebook) {
        notebookRepository.save(notebook);
    }

    @Override
    public Notebook findNotebookById(int id) {
        Optional<Notebook> notebook = notebookRepository.findById(id);
        return notebook.map(o -> notebook.get()).orElseThrow(() -> new NoSuchNotebookException("Notebook not found!"));
    }

    @Override
    public void deleteNotebook(Notebook notebook) {
        notebookRepository.delete(notebook);
    }

    @Override
    public List<Notebook> findAllNotebooks() {
        return notebookRepository.findAll();
    }
}
