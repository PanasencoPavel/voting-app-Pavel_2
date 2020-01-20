package com.usmteam3.votingapp.model.enums;


public enum Note {

    ONE(1),

    TWO(2),

    THREE(3),

    FOUR(4),

    FIVE(5);

    private Integer noteValue;

    private Note(Integer intValue) {
        this.noteValue = intValue;
    }

    public Integer showNote() {
        return noteValue;
    }
}
