package io.hexlet.xo.view;

import io.hexlet.xo.model.Game;
import io.hexlet.xo.model.*;
import io.hexlet.xo.model.Point;

public class ConsoleView {
    public String lastPrint;

    private StringBuilder fieldBuilder;

    public void show(final Game game) {
        fieldBuilder = new StringBuilder();
        Field field = game.getField();
        for (int x = 0; x < field.getSize(); x++) {
            if (x != 0) {
                generateSeparator(this.fieldBuilder);
            }
            generateLine(field, x, this.fieldBuilder);
        }
        System.out.println(fieldBuilder.toString());
    }

    public void generateLine(final Field field, final int x, final StringBuilder sb) {

        for (int y = 0; y < field.getSize(); y++) {
            if (y != 0) {
                sb.append("|");
            }

            sb.append(" ");
            Figure figure = field.getFigure(new Point(x, y));
            sb.append(figure != null ? figure : " ");
            sb.append(" ");
        }
        sb.append("\n");

    }

    private static void generateSeparator(final StringBuilder sb) {
        sb.append("~~~~~~~~~~~\n");
    }

    public StringBuilder getFieldBuilder() {
        return fieldBuilder;
    }

    public boolean move(final Game game) {
        return false;
    }
}
