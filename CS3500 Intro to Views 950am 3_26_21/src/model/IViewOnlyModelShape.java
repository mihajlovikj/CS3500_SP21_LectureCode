package model;

import java.awt.Color;

public interface IViewOnlyModelShape {
  ModelShapeType getType();
  //Obvserver methods
  int getX();
  int getY();
  int getW();
  int getH();
  Color getColor();
}
