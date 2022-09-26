package model;

import java.time.LocalDate;

public class Score {

    private LocalDate date;
    private String winner;
    private int scoreWinner;
    private int scoreLooser;

    public Score(String winner, int scoreWinner, int scoreLooser) {
        this.date = LocalDate.now();
        this.winner = winner;
        this.scoreWinner = scoreWinner;
        this.scoreLooser = scoreLooser;
    }

    @Override
    public String toString() {
        return String.format("%s: %s %d - %d", date, winner, scoreWinner, scoreLooser);
    }
}
