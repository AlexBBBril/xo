import io.hexlet.xo.model.*;
import io.hexlet.xo.model.Point;
import io.hexlet.xo.view.ConsoleView;

public class Main {

    public static void main(String... args) {
        final Player p1 = new Player("Slava", Figure.X);
        final Player p2 = new Player("Gleb", Figure.O);
        final Field field = new Field();
        final Game game = new GameBuilder().player1(p1).player2(p2).field(field).name("XO").build();
        final ConsoleView cv = new ConsoleView();


        field.setFigure(new Point(0, 0), Figure.O);
        field.setFigure(new Point(1, 0), Figure.X);
        field.setFigure(new Point(0, 1), Figure.X);
        field.setFigure(new Point(2, 2), Figure.O);


        // test line
        final StringBuilder lineBuilder = new StringBuilder();
        final String expectedLine = " O | X |   \n";
        cv.generateLine(field, 0, lineBuilder);
        final String actualLine = lineBuilder.toString();

        if (!expectedLine.equals(actualLine)) {
            throw new RuntimeException(String.format("Line generated:\n01234567890\n%s instead of:\n01234567890\n%s", actualLine, expectedLine));
        }

        // test separator


        // test full Field
        final String expectedField = " O | X |   \n" +
                "~~~~~~~~~~~\n" +
                " X |   |   \n" +
                "~~~~~~~~~~~\n" +
                "   |   | O \n";

        cv.show(game);
        final String actualField = cv.getFieldBuilder().toString();

        if (!expectedField.equals(actualField)) {
            throw new RuntimeException(String.format("Field generated:\n01234567890\n%s instead of:\n01234567890\n%s", actualField, expectedField));
        }

        otherTest();
    }

    private static void otherTest() {
        final Player p1 = new Player("Slava", Figure.X);
        final Player p2 = new Player("Gleb", Figure.O);
        final Field field = new Field();
        final Game game = new GameBuilder().player1(p1).player2(p2).field(field).name("XO").build();
        final ConsoleView cv = new ConsoleView();


        field.setFigure(new Point(2, 0), Figure.X);
        field.setFigure(new Point(0, 1), Figure.O);
        field.setFigure(new Point(1, 0), Figure.X);
        field.setFigure(new Point(1, 1), Figure.O);
        field.setFigure(new Point(0, 0), Figure.X);

        // test full Field
        final String expectedField = " X | O |   \n" +
                "~~~~~~~~~~~\n" +
                " X | O |   \n" +
                "~~~~~~~~~~~\n" +
                " X |   |   \n";

        cv.show(game);
        final String actualField = cv.getFieldBuilder().toString();

        if (!expectedField.equals(actualField)) {
            throw new RuntimeException(String.format("Field generated:\n01234567890\n%s instead of:\n01234567890\n%s", actualField, expectedField));
        }
    }
}