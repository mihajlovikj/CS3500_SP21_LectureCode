package view;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

public interface IView {
  void render();
  void drawEllipse(int x, int y, int w, int h, Color color);
  void drawRectangle(int x, int y, int w, int h, Color color);
  void refresh();
  void addListener(ViewListner listner);
  void resetFocus();
  void displayError(String message);

}
