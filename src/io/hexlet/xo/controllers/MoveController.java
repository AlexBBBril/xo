package io.hexlet.xo.controllers;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Point;

public class MoveController {

    public boolean applyFigure(final Field field,
                               final Point point,
                               final String figure) {
        if (checkCoordinate(point.x) && checkCoordinate(point.x) && null == field.getFigure(point)) {

            field.setFigure(point, figure);

            return true;
        }

        return false;
    }

    private boolean checkCoordinate(final int coordinate) {

        return coordinate >= 0 && coordinate < Field.FIELD_SIZE;
    }

}