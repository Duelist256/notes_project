package com.epam.enote.service;

import com.epam.enote.model.Notebook;
import com.epam.enote.persistence.NotebookRepository;
import com.epam.enote.service.impl.NotebookServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class NotebookServiceTest {

    @Mock
    private NotebookRepository notebookRepository;

    @InjectMocks
    private NotebookServiceImpl notebookService;

    @Test
    public void addNotebook() throws Exception {
        doReturn(Notebook.newBuilder().build()).when(notebookRepository).save(any());

        Notebook notebook = Notebook.newBuilder()
                .userId(15)
                .build();

        notebookService.addNotebook(notebook);
        verify(notebookRepository, times(1)).save(notebook);
    }

    @Test
    public void updateNotebook() throws Exception {
        doReturn(Notebook.newBuilder().build()).when(notebookRepository).save(any());

        Notebook notebook = Notebook.newBuilder()
                .id(1)
                .userId(15)
                .build();

        notebookService.updateNotebook(notebook);
        verify(notebookRepository, times(1)).save(notebook);
    }

    @Test
    public void findNotebookById() throws Exception {
        doReturn(Optional.of(Notebook.newBuilder().build())).when(notebookRepository).findById(anyInt());
        int id = 2;
        notebookService.findNotebookById(id);
        verify(notebookRepository, times(1)).findById(id);
    }

    @Test
    public void deleteNotebook() throws Exception {
        fail("Method isn't implemented");
    }

    @Test
    public void findAllNotebooks() throws Exception {
        fail("Method isn't implemented");
    }

}