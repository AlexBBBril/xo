package io.hexlet.xo.view;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.Point;
import io.hexlet.xo.model.exceptions.InvalidPointException;

public class AICoordinateGetter implements ICoordinateGetter {
    private final Point[] STEPS = {
            new Point(1,1),
            new Point(0,0),
            new Point(0,2),
            new Point(2,0),
            new Point(2,2),
            new Point(0,1),
            new Point(1,0),
            new Point(1,2),
            new Point(2,1),
    };

    @Override
    public Point getMoveCoordinate(Field field) throws InvalidPointException {
        for (Point point: STEPS) {
            Figure figure = field.getFigure(point);
            if (null == figure) {
                return point;
            }
        }

        return null;
    }

}
