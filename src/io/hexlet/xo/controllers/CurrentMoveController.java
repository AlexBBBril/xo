package io.hexlet.xo.controllers;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Point;

public class CurrentMoveController {

    public String currentMove(final Field field) {
        int sizeX = 0;
        int sizeO = 0;

        int fieldSize = field.getSize();

        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                String figure = field.getFigure(new Point(i, j));

                if ("X".equals(figure)) {
                    sizeX++;
                } else if(("O").equals(figure)) {
                    sizeO++;
                }
            }
        }

        if (sizeX > sizeO) {
            return "O";
        } else {
            return "X";
        }
    }
}
