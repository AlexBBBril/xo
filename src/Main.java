import io.hexlet.xo.controllers.CurrentMoveController;
import io.hexlet.xo.model.*;

import java.util.Random;

public class Main {

    public static void main(String... args) {
        final Field field = new Field();
        final CurrentMoveController cmc = new CurrentMoveController();

        final Point p = new Point();
        p.x = 1;
        p.y = 1;

        if (!"X".equals(cmc.currentMove(field))){
            throw new RuntimeException("Controller do not returns \"X\" when the field is empty!");
        }

        for (int i = 0; i < field.getSize(); i++) {
            for (int i2 = 0; i2 < field.getSize(); i2++) {
                p.x = i;
                p.y = i2;
                final String settingFigure = (i * 3 + i2) % 2 == 0 ? "X" : "O";
                field.setFigure(p, settingFigure);
                System.out.printf("\nputting figure: %s to the: x:%d y:%d\n", settingFigure, p.x, p.y);
                String expectedFigure = settingFigure.equals("X") ? "O" : "X";
                String actualFigure = cmc.currentMove(field);
                String message = String.format("The currentMov method should have returned %s" +
                                ", but returned %s" +
                                ", for the following field: %s"
                        , expectedFigure, actualFigure, field.toString());
                if (!expectedFigure.equals(actualFigure)){
                    throw new RuntimeException(message);
                }
            }
        }

//		System.out.println(field.toString());

        final Field field2 = new Field();
        field2.setFigure(new Point(1,1), "X");
//		System.out.println(field2.toString());
        System.out.println("\n\n Other test:");
//		System.out.printf("\nputting figure: %s to the: X:%d Y:%d\n", "X", 1, 1);
        if (!"O".equals(cmc.currentMove(field2))) {
            throw new RuntimeException(String.format("returns %s for the field: \n%s\n but must be return `O`", cmc.currentMove(field2), field2.toString()));
        }

        System.out.println("Success! Push the button \"Отправить на ревью\" or \"Завершить\".");
    }
}
