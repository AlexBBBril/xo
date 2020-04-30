package io.hexlet.xo.view;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Point;
import io.hexlet.xo.model.exceptions.InvalidPointException;

public interface ICoordinateGetter {
    Point getMoveCoordinate(Field field) throws InvalidPointException;
}
