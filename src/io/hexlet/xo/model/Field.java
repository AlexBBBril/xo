package io.hexlet.xo.model;

public class Field {

    public String f00;

    public String f01;

    public String f02;

    public String f10;

    public String f11;

    public String f12;

    public String f20;

    public String f21;

    public String f22;

    public int getSize() {
        return 3;
    }

    public String getFigure(final Point p) {
        if (p.x == 0 && p.y == 0) return f00;
        if (p.x == 1 && p.y == 0) return f10;
        if (p.x == 2 && p.y == 0) return f20;
        if (p.x == 0 && p.y == 1) return f01;
        if (p.x == 1 && p.y == 1) return f11;
        if (p.x == 2 && p.y == 1) return f21;
        if (p.x == 0 && p.y == 2) return f02;
        if (p.x == 1 && p.y == 2) return f12;
        if (p.x == 2 && p.y == 2) return f22;

        throw new RuntimeException("OLOLOLOL");
    }

    public void setFigure(final Point p, final String figure) {
        if (p.x == 0 && p.y == 0){
            f00 = figure;
        }
        if (p.x == 1 && p.y == 0){
            f10 = figure;
        }
        if (p.x == 2 && p.y == 0){
            f20 = figure;
        }
        if (p.x == 0 && p.y == 1){
            f01 = figure;
        }
        if (p.x == 1 && p.y == 1){
            f11 = figure;
        }
        if (p.x == 2 && p.y == 1){
            f21 = figure;
        }
        if (p.x == 0 && p.y == 2){
            f02 = figure;
        }
        if (p.x == 1 && p.y == 2){
            f12 = figure;
        }
        if (p.x == 2 && p.y == 2){
            f22 = figure;
        }
    }
}