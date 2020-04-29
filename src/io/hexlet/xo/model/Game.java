package io.hexlet.xo.model;

public class Game {

    private final Player player1;

    private final Player player2;

    private final Field field;

    private final String name;

    Game(final Game.Builder builder) {
        this.player1 = builder.getPlayer1();
        this.player2 = builder.getPlayer2();
        this.field = builder.getField();
        this.name = builder.getName();
    }

    public Player getPlayer1() {
        return this.player1;
    }

    public Player getPlayer2() {
        return this.player2;
    }

    public Field getField() {
        return field;
    }

    public String getName() {
        return name;
    }

    public static class Builder {
        private Player player1;

        private Player player2;

        private Field field;

        private String name;

        public io.hexlet.xo.model.Game.Builder player1(final Player player1) {
            this.player1 = player1;

            return this;
        }

        public io.hexlet.xo.model.Game.Builder player2(final Player player2) {
            this.player2 = player2;

            return this;
        }

        public io.hexlet.xo.model.Game.Builder field(final Field field) {
            this.field = field;

            return this;
        }

        public io.hexlet.xo.model.Game.Builder name(final String name) {
            this.name = name;

            return this;
        }

        public Game build() {
            return new Game(this);
        }

        public Player getPlayer1() {
            return player1;
        }

        public Player getPlayer2() {
            return player2;
        }

        public Field getField() {
            return field;
        }

        public String getName() {
            return name;
        }
    }
}