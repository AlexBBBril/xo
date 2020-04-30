package io.hexlet.xo.view;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.Point;
import io.hexlet.xo.model.exceptions.InvalidPointException;

import java.util.Random;

public class RandomCoordinateGetter implements ICoordinateGetter {

    @Override
    public Point getMoveCoordinate(Field field) throws InvalidPointException {
        Random rand = new Random();
        Point point = new Point(rand.nextInt(3), rand.nextInt(3));

        Figure figure = field.getFigure(point);
        if (null == figure) {
            return point;
        } else {
            return this.getMoveCoordinate(field);
        }
    }

}
