package model;

import java.awt.Color;
import java.awt.Shape;

public interface IReadOnlyModelShape extends Shape {
  Color getColor();
  ModelShapeType getType();
  IReadOnlyModelShape makeShape(int x, int y, int w, int h, Color color); // factory method.
}
