package com.epam.enote.model;

import javax.persistence.*;

@Entity
@Table(name = "enote.notes")
public class Note {

    @Id
    @GeneratedValue
    private int id;

    private String text;

    private int notebookId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getNotebookId() {
        return notebookId;
    }

    public void setNotebookId(int notebookId) {
        this.notebookId = notebookId;
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

        Note note = (Note) obj;

        if (id != note.getId()) {
            return false;
        }

        if (!text.equals(note.getText())) {
            return false;
        }

        if (notebookId != note.getNotebookId()) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + id;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + notebookId;
        return result;
    }

    public class Builder {
        private Builder() {
        }

        public Builder id(int id) {
            Note.this.id = id;
            return this;
        }

        public Builder text(String text) {
            Note.this.text = text;
            return this;
        }

        public Builder notebookId(int notebookId) {
            Note.this.notebookId = notebookId;
            return this;
        }

        public Note build() {
            return Note.this;
        }
    }
}
