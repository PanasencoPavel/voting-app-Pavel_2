package com.usmteam3.votingapp.util;

import com.usmteam3.votingapp.model.enums.Note;

import javax.persistence.AttributeConverter;
import java.util.Optional;

import static java.util.Arrays.stream;

public class NoteConverter implements AttributeConverter<Note, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Note note) {
        return note.showNote();
    }

    @Override
    public Note convertToEntityAttribute(Integer noteValue) {
        Optional<Note> note = stream(Note.values()).filter(n -> n.showNote() == noteValue).findFirst();
        if (note.isPresent()) {
            return note.get();
        } else {
            throw new IllegalArgumentException("Please provide valid note");
        }
    }
}
