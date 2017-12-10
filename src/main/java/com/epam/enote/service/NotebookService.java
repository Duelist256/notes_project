package com.epam.enote.service;

import com.epam.enote.model.Notebook;

import java.util.List;

public interface NotebookService {
    void addNotebook(Notebook notebook);

    void updateNotebook(Notebook notebook);

    Notebook findNotebookById(int id);

    void deleteNotebook(Notebook notebook);

    List<Notebook> findAllNotebooks();
}
