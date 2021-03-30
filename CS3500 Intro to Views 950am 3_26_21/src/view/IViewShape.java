package view;

import java.awt.Color;

public interface IViewShape {
    ViewShapeType getType();
    int getX();
    int getY();
    int getW();
    int getH();
    Color getColor();
}
