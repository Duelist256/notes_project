package com.epam.enote.model;

import javax.persistence.*;

@Entity
@Table(name = "note")
public class Note {

    @Basic
    @Column(name = "id")
    int id;

    @Basic
    @Column(name = "name")
    String text;

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

        if (text != note.getText()) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * id + (text != null ? text.hashCode() : 0);
        return result;
    }

    public class Builder {
        private Builder() {}

        public Builder id(int id) {
            Note.this.id = id;
            return this;
        }

        public Builder text(String text) {
            Note.this.text = text;
            return this;
        }

        public Note build() {
            return Note.this;
        }
    }
}
