package model;

import java.awt.Color;
import java.util.List;

public interface IModel {
  void addRectangle(int x, int y, int w, int h, Color color);
  void addEllipse(int x, int y, int w, int h, Color color);
  List<IViewOnlyModelShape> getShapesAtTick(int tick);
}
