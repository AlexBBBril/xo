package io.hexlet.xo.controllers;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Point;

public class CurrentMoveController {

    public String currentMove(final Field field) {
        int countFigure = 0;
        for (int x = 0; x < field.getSize(); x++) {
            countFigure += countFiguresInTheRow(field, x);
        }

        if (countFigure == field.getSize() * field.getSize())
            return null;

        if (countFigure % 2 == 0)
            return "X";

        return "O";
    }

    private int countFiguresInTheRow(final Field field, final Integer row) {
        int countFigure = 0;
        for (int x = 0; x < field.getSize(); x++) {
            Point point = new Point(x, row);

            if (field.getFigure(point) != null)
                countFigure++;
        }
        return countFigure;
    }
}