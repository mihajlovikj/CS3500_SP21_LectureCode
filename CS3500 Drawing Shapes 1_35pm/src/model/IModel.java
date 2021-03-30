package model;

import java.awt.Color;


public interface IModel extends IViewModel {
  void addRectangle(String id, int x, int y, int w, int h, Color color);
  void addEllipse(String id, int x, int y, int w, int h, Color color);
  void addMoveMotion(String id, int sT, int eT, int sX, int eX);
  void addWidthMotion(String id, int sT, int eT, int sW, int eW);
  void addMotion(String id, int sT, int x, int y, int w, int h, int r, int g, int b,
                            int eT, int x1, int y1, int w1, int h1, int r1, int g1, int b1);
}
