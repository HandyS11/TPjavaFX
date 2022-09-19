package model;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Player> players = new ArrayList<Player>();
    private Dice dice;
    private int looser;

    public Game(int nbFaces, String playerName1, String playerName2) {
        players.add(new Player(playerName1));
        players.add(new Player(playerName2));
        dice = new Dice(nbFaces);
        looser = 0;
    }

    public List<String> getPlayersNames() {
        List<String> names = new ArrayList<String>();
        players.forEach((player -> {
            names.add(player.getName());
        }));
        return names;
    }

    public int play(int player) {
        int value = dice.roll();
        Player p = players.get(player - 1);
        p.incrementScore(value);
        if (value == 1) {
            looser = (player - 1);
            return 0;
        }
        return p.getNbPoint();
    }

    public void playAgain() {

    }
}
