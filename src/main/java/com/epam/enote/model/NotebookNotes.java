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

    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }

        if (this == obj) {
            return true;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        NotebookNotes notebookNotes = (NotebookNotes) obj;

        if (notebookId != notebookNotes.getNotebookId()) {
            return false;
        }

        if (noteId != notebookNotes.getNoteId()) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = notebookId;
        result = 31 * result + noteId;
        return result;
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
