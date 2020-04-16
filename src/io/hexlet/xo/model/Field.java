package io.hexlet.xo.model;

public class Field {
    public static final int FIELD_SIZE = 3;

    private String[][] figures = new String[FIELD_SIZE][FIELD_SIZE];

    public int getSize() {
        return this.figures.length;
    }

    public String getFigure(final Point point) {
        return this.figures[point.x][point.y];
    }

    public void setFigure(final Point point, final String figure) {
        this.figures[point.x][point.y] = figure;
    }
}