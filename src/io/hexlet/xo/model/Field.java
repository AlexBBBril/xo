package io.hexlet.xo.model;

import io.hexlet.xo.model.exceptions.InvalidPointException;

public class Field {

    private static final int MIN_COORDINATE = 0;

    private final Figure[][] field;

    private final int fieldSize;

    public Field(final int fieldSize) {
        this.fieldSize = fieldSize;
        field = new Figure[fieldSize][fieldSize];
    }

    public int getSize() {
        return fieldSize;
    }

    public Figure getFigure(final Point point) throws InvalidPointException {
        checkCoordinate(point);

        return this.field[point.getX()][point.getY()];
    }

    public void setFigure(final Point point, final Figure figure) throws InvalidPointException {
        checkCoordinate(point);

        this.field[point.getX()][point.getY()] = figure;
    }

    private void checkCoordinate(final Point point) throws InvalidPointException {
        if (point.getY() < MIN_COORDINATE || point.getX() < MIN_COORDINATE) {
            throw new InvalidPointException();
        }
        if (point.getY() > this.fieldSize - 1 || point.getX() > this.fieldSize - 1) {
            throw new InvalidPointException();
        }
    }

}
