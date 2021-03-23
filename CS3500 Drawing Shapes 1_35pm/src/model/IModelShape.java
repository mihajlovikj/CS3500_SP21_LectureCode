package model;

import java.awt.Color;
import java.awt.Shape;

public interface IModelShape extends Shape {
  Color getColor();
  IModelShape transform(int tick);
  ModelShapeType getType();
}
