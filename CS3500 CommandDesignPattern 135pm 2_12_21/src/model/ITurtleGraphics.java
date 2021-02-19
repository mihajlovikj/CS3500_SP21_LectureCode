package model;

import java.awt.Point;
import java.awt.geom.Line2D;
import java.util.List;


public interface ITurtleGraphics {
  void move(double distance);
  void turn(double angle);
  void save();//Save the current position so we can go back to.
  void retrieve(); //Restores or moves the turtle to the last saved position.
  Point getPosition();


}
