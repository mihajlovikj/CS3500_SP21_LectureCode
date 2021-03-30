package model;

import java.awt.Color;
import java.util.List;

public interface IModel {
  void addRectangle(String id, int x, int y, int w, int h, Color color) throws IllegalArgumentException;
  void addMoveMotion(String id, int sT, int eT, int sX, int eX);
  List<IViewOnlyModelShape> getShapesAtTick(int tick);
}
