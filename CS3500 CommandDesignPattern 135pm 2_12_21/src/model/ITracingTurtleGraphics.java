package model;

import java.awt.geom.Line2D;
import java.util.List;

public interface ITracingTurtleGraphics extends ITurtleGraphics{
  void trace(double distance);
  List<Line2D> getLines();
}
