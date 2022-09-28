package model;

import java.time.LocalDate;

public class Score {

    private LocalDate date;
    private String winner;
    private String looser;
    private int scoreWinner;
    private int scoreLooser;

    public Score(String winner, String looser, int scoreWinner, int scoreLooser) {
        this.date = LocalDate.now();
        this.winner = winner;
        this.looser = looser;
        this.scoreWinner = scoreWinner;
        this.scoreLooser = scoreLooser;
    }

    public LocalDate getDate() { return date; }

    public String getWinner() { return winner; }

    public String getLooser() { return looser; }

    public int getScoreWinner() { return scoreWinner; }

    public int getScoreLooser() { return scoreLooser; }

    @Override
    public String toString() {
        return String.format("The %s: %s won %d - %d!", date, winner, scoreWinner, scoreLooser);
    }
}
