package io.hexlet.xo.controllers;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.Point;
import io.hexlet.xo.model.exceptions.InvalidPointException;

import java.util.Arrays;

public class WinnerController {

    public Figure getWinner(final Field field) throws InvalidPointException {
        Figure winner;
        for (int i = 0; i < field.getSize(); i++) {
            winner = checkRow(field, i);
            if (winner != null) return winner;
            winner = checkColumn(field, i);
            if (winner != null) return winner;
        }
        winner = checkDiag1(field);
        if (winner != null) return winner;
        winner = checkDiag2(field);
        if (winner != null) return winner;

        return null;
    }

    private Figure checkDiag1(final Field field) throws InvalidPointException {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(1, 1);
        Point p3 = new Point(2, 2);

        if (field.getFigure(p1) != null && field.getFigure(p2) != null &&
                field.getFigure(p3) != null &&
                field.getFigure(p1).equals(field.getFigure(p2)) &&
                field.getFigure(p1).equals(field.getFigure(p3))) {
            return field.getFigure(p1);
        }
        return null;
    }

    private Figure checkDiag2(final Field field) throws InvalidPointException {

        Point p1 = new Point(2, 0);
        Point p2 = new Point(1, 1);
        Point p3 = new Point(0, 2);

        if (field.getFigure(p1) != null && field.getFigure(p2) != null
                && field.getFigure(p3) != null &&
                field.getFigure(p1).equals(field.getFigure(p2)) &&
                field.getFigure(p1).equals(field.getFigure(p3))) {
            return field.getFigure(p1);
        }
        return null;
    }

    private Figure checkColumn(final Field field, final Integer i) throws InvalidPointException {
        Point p1 = new Point(0, i);
        Point p2 = new Point(1, i);
        Point p3 = new Point(2, i);

        if (field.getFigure(p1) != null && field.getFigure(p2) != null
                && field.getFigure(p3) != null &&
                field.getFigure(p1).equals(field.getFigure(p2)) &&
                field.getFigure(p1).equals(field.getFigure(p3))) {
            return field.getFigure(p1);
        }
        return null;
    }

    private Figure checkRow(final Field field, final Integer i) throws InvalidPointException {
        Point p1 = new Point(i, 0);
        Point p2 = new Point(i, 1);
        Point p3 = new Point(i, 2);

        if (field.getFigure(p1) != null && field.getFigure(p2) != null
                && field.getFigure(p3) != null &&
                field.getFigure(p1).equals(field.getFigure(p2)) &&
                field.getFigure(p1).equals(field.getFigure(p3))) {
            return field.getFigure(p1);
        }
        return null;
    }
}