package com.test.task;

public class BracketPair {
    private final char openingBracket;
    private char closingBracket;
    private final int openingPosition;
    private int closingPosition;

    public BracketPair(char openingBracket, int openingPosition) {
        this.openingBracket = openingBracket;
        this.openingPosition = openingPosition;
    }

    public void setClosingBracketAndPosition(char closingBracket, int closingPosition) {
        this.closingBracket = closingBracket;
        this.closingPosition = closingPosition;
    }

    public char getOpeningBracket() {
        return openingBracket;
    }

    @Override
    public String toString() {
        return openingBracket + " - " + openingPosition + " , " + closingBracket + " - " + closingPosition + "\n";
    }
}
