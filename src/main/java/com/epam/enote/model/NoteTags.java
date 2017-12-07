package com.epam.enote.model;

import javax.persistence.*;

@Entity
@Table(name = "note_tags")
public class NoteTags {
    @Basic
    @Column(name = "noteId")
    int noteId;

    @Basic
    @Column(name = "tagId")
    int tagId;

    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    public class Builder {
        private Builder() {}

        public Builder noteId(int noteId) {
            NoteTags.this.noteId = noteId;
            return this;
        }

        public Builder tagId(int tagId) {
            NoteTags.this.tagId = tagId;
            return this;
        }

        public  NoteTags build() {
            return NoteTags.this;
        }
    }
}
