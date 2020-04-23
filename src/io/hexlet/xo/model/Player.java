package io.hexlet.xo.model;

public class Player {

    public String name;

    public String figure;

    public Player(String name, String figure) {
        this.name = name;
        this.figure = figure;
    }

    public String getName() {
        return name;
    }

    public String getFigure() {
        return figure;
    }
}
