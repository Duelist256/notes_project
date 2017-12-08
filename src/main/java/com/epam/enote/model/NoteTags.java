package com.epam.enote.model;

import javax.persistence.*;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NoteTags noteTags = (NoteTags) o;
        return noteId == noteTags.noteId &&
                tagId == noteTags.tagId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(noteId, tagId);
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
