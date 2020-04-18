package io.hexlet.xo.view;

import io.hexlet.xo.model.Game;
import io.hexlet.xo.model.*;
import io.hexlet.xo.model.Point;

public class ConsoleView {
    public String lastPrint;

    public  String show(final Field field) {
        final StringBuilder fieldBuilder = new StringBuilder();
        for (int x = 0; x < field.getSize(); x++) {
            if (x != 0) {
                fieldBuilder.append("  ");
                generateSeparator(fieldBuilder);
            }
            fieldBuilder.append("  ");
            generateLine(field, x, fieldBuilder);
        }
        lastPrint = fieldBuilder.toString();
        return lastPrint;
    }

    private static void generateLine(final Field field, final int x, final StringBuilder sb) {

        for (int y = 0; y < field.getSize(); y++) {
            if (y != 0)
                sb.append("|");
            sb.append(" ");
            String figure = field.getFigure(new Point(x, y));
            sb.append(figure != null ? figure : " ");
            sb.append(" ");
        }
        sb.append("\n");

    }

    private static void generateSeparator(final StringBuilder sb) {
        sb.append("~~~~~~~~~~~\n");
    }

    public boolean move(final Game game) {
        return false;
    }
}
