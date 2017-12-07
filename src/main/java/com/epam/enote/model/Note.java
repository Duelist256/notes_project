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
