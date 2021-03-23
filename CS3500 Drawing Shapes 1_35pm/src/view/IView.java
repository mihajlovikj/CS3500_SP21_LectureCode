package view;

import java.awt.Color;

public interface IView {
  void render();
  void drawEllipse(int x, int y, int w, int h, Color color);
  void drawRectangle(int x, int y, int w, int h, Color color);
  void refresh();
}
