package io.hexlet.xo.controllers;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Point;

import java.util.Arrays;

public class WinnerController {

    public String getWinner(final Field field) {
        int countX, countO;
        int fieldSize = field.getSize();

        String[][] combinations = concatAll(
                getLineCombinations(fieldSize, field, true),
                getLineCombinations(fieldSize, field, false),
                getDiagonalCombinations(fieldSize, field, 0, 1),
                getDiagonalCombinations(fieldSize, field, fieldSize-1, -1)
        );

        for (String[] combination : combinations) {
            countX = 0;
            countO = 0;

            for (String s : combination) {
                switch (s) {
                    case "":
                        continue;
                    case "X":
                        countX++;
                        break;
                    case "O":
                        countO++;
                }
            }

            if (fieldSize == countX) {
                return "X";
            }
            if (fieldSize == countO) {
                return "O";
            }
        }

        return null;
    }

    private String[][] getLineCombinations(int size, Field field, boolean isHorizontal){
        String[][] line = new String[size][];

        for (int x = 0; x < size; x++) {
            String[] temp = new String[size];
            for (int y = 0; y < size; y++) {
                if (isHorizontal) {
                    temp[y] = createFigure(field, new Point(x, y));
                } else {
                    temp[y] = createFigure(field, new Point(y, x));
                }
            }
            line[x] = temp;
        }

        return line;
    }

    private String createFigure(Field field, Point point) {
        String figure = field.getFigure(point);
        if (null == figure){
            figure = "";
        }
        return figure;
    }

    private String[][] getDiagonalCombinations(int size, Field field, int y, int yMagnifier){
        String[][] line = new String[1][];

        String[] temp = new String[size];
        for (int x = 0; x < size; x++) {
            temp[y] = createFigure(field, new Point(x, y));;
            y = y + yMagnifier;
        }

        line[0] = temp;

        return line;
    }

    @SafeVarargs
    public static <T> T[] concatAll(T[] first, T[]... rest) {
        int totalLength = first.length;
        for (T[] array : rest) {
            totalLength += array.length;
        }
        T[] result = Arrays.copyOf(first, totalLength);
        int offset = first.length;
        for (T[] array : rest) {
            System.arraycopy(array, 0, result, offset, array.length);
            offset += array.length;
        }
        return result;
    }
}
