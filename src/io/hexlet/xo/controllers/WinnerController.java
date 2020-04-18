package io.hexlet.xo.controllers;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Point;

import java.util.Arrays;

public class WinnerController {

    public String getWinner(final Field field) {
        int countX, countO;
        int fieldSize = field.getSize();

        String[][] combinations = new String[fieldSize*2+2][];

        var result = getLineCombinations(fieldSize, field, true);
        var result1 = getLineCombinations(fieldSize, field, false);
        var result3 = getDiagonalCombinations(fieldSize, field, 0, 1);
        var result4 = getDiagonalCombinations(fieldSize, field, fieldSize-1, -1);

        combinations = concatAll(result, result1, result3, result4);

        for (int i = 0; i < combinations.length; i++) {
            for (int j = 0; j < combinations[i].length; j++) {

            }

//            switch (figure) {
//                case "X":
//
//                    break;
//                case "Y":
//
//                    break;
//                default:
//                    continue;
//                    break;
//            }
        }


//        for (int x = 0; x < fieldSize; x++) {
//            for (int y = 0; y < fieldSize; y++) {
//                String figure = field.getFigure(new Point(x, y));
//                switch (figure) {
//                    case "X":
//
//                        break;
//                    case "Y":
//
//                        break;
//                    default:
//                        continue;
//                        break;
//                }
//
//            }
//        }

//        if (fieldSize == countO) {
//            return "O";
//        } else if (fieldSize == countX) {
//            return "X";
//        }

        return null;
    }

    private String[][] getLineCombinations(int size, Field field, boolean isHorizontal){
        String[][] line = new String[size][];

        for (int x = 0; x < size; x++) {
            String[] temp = new String[size];
            for (int y = 0; y < size; y++) {
                if (isHorizontal) {
                    temp[y] = field.getFigure(new Point(x, y));
                } else {
                    temp[y] = field.getFigure(new Point(y, x));
                }
            }
            line[x] = temp;
        }

        return line;
    }

    private String[][] getDiagonalCombinations(int size, Field field, int y, int yMagnifier){
        String[][] line = new String[1][];

        String[] temp = new String[size];
        for (int x = 0; x < size; x++) {
            temp[y] = field.getFigure(new Point(x, y));
            y = y + yMagnifier;
        }

        line[0] = temp;

        return line;
    }

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
