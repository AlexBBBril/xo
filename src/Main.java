import io.hexlet.xo.model.*;

import java.util.Random;

public class Main {

    private static final io.hexlet.xo.model.Field field = new io.hexlet.xo.model.Field();
    private static final Random r = new Random();
    private static final String[] figures = {"X", "O"};
    private static final String[] figuresOnField = new String[field.getSize() * field.getSize()];
    private static int allFiguresCounter = 0;

    public static void main(String... args) {

        testSetFigure();
        testGetFigure();

    }

    private static void testSetFigure() {

        for (int i = 0; i < field.getSize(); i++) {
            for (int i2 = 0; i2 < field.getSize(); i2++) {
                final Point p = new Point();
                p.x = i;
                p.y = i2;

                String randomFigure;
                figuresOnField[allFiguresCounter++] = randomFigure = figures[r.nextInt(2)];
                field.setFigure(p, randomFigure);

                java.lang.reflect.Field f = null;
                try {
                    f = io.hexlet.xo.model.Field.class.getDeclaredField(String.format("f%d%d", i, i2));
                    f.setAccessible(true);
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }
                try {
                    String realFigureOnField = (String) f.get(field);
                    if (!randomFigure.equals(realFigureOnField)) {
                        throw new RuntimeException(String.format(
                                "\nYOUR method \"setFigure\" did not set the figure \"%s\" in the coordinates: x = %d, y = %d to the variable \"f%d%d\".",
                                randomFigure, i, i2, i, i2));
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    private static void testGetFigure() {
        allFiguresCounter = 0;
        for (int i = 0; i < field.getSize(); i++) {
            for (int i2 = 0; i2 < field.getSize(); i2++) {
                final Point p = new Point();
                p.x = i;
                p.y = i2;
                final String randomFigure = figuresOnField[allFiguresCounter++];

                String actualFigure = field.getFigure(p);

                if (!randomFigure.equals(actualFigure)) {
                    throw new RuntimeException(String.format("\nFigure on coordinates: x = %d, y = %d equals to \"%s\" instead of \"%s\".", i, i2, actualFigure, randomFigure));
                }
            }
        }
    }
}
