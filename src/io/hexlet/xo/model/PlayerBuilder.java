package io.hexlet.xo.model;

public class PlayerBuilder {

    private String name;

    private String figure;

    public PlayerBuilder name(final String name) {
        this.name = name;

        return this;
    }

    public PlayerBuilder figure(final String figure) {
        this.figure = figure;

        return this;
    }

    public String getName() {
        return name;
    }

    public String getFigure() {
        return figure;
    }

    public Player build() {
        return new Player(this);
    }
}
