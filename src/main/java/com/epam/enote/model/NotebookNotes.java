package com.epam.enote.model;

import javax.persistence.*;

@Entity
@Table(name = "notebook_notes")
public class NotebookNotes {
    @Basic
    @Column(name = "notebookId")
    int notebookId;

    @Basic
    @Column (name = "noteId")
    int noteId;

    public int getNotebookId() {
        return notebookId;
    }

    public void setNotebookId(int notebookId) {
        this.notebookId = notebookId;
    }

    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    public class Builder {
        private Builder() {}

        public Builder notebookId(int notebookId) {
            NotebookNotes.this.notebookId = notebookId;
            return this;
        }

        public Builder noteId(int noteId) {
            NotebookNotes.this.noteId = noteId;
            return this;
        }

        public NotebookNotes build() {
            return NotebookNotes.this;
        }

    }
}
