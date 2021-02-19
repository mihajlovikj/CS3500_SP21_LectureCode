package SimpleModel;

import java.awt.geom.Line2D;
import java.util.List;

public interface ITurtleModel {
  void move(double distance);
  void turn(double angle);
  void save();//pushes the current of the turtle on a stack.
  void retrieve();//restores the last saved position from the stack
  java.awt.Point getPosition();
}
