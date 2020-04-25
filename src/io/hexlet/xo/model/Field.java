package io.hexlet.xo.model;

public class Field {

    private final Figure[][] figures = new Figure[3][3];

    public int getSize() {
        return this.figures.length;
    }

    public Figure getFigure(final Point point) {
        return this.figures[point.getX()][point.getY()];
    }

    public void setFigure(final Point point, final Figure figure) {
        this.figures[point.getX()][point.getY()] = figure;
    }

}
