package io.hexlet.xo.model;

public class Game {

    public Player player1;

    public Player player2;

    public Field field;

    public String name;

    public Game(Player player1, Player player2, Field field, String name) {
        this.player1 = player1;
        this.player2 = player2;
        this.field = field;
        this.name = name;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }
}