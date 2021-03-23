package model;

import java.awt.Color;


public interface IModel extends IViewModel {
  void addRectangle(String id, int x, int y, int w, int h, Color color);
  void addEllipse(String id, int x, int y, int w, int h, Color color);
}
