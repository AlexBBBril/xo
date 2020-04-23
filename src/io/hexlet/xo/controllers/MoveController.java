package io.hexlet.xo.controllers;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Point;

public class MoveController {

    public boolean applyFigure(final Field field,
                               final Point point,
                               final String figure) {
        if (checkCoordinate(point.getX()) && checkCoordinate(point.getY()) && null == field.getFigure(point)) {

            field.setFigure(point, figure);

            return true;
        }

        return false;
    }

    private boolean checkCoordinate(final int coordinate) {

        return coordinate >= 0 && coordinate < 3;
    }

}