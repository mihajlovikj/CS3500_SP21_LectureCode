package view;

import java.awt.Color;
import view.DrawingPanel.IDrawingPanelShape;

public interface IView {
  void render();
  void drawShape( IViewShape shape);
  void drawEllipse( int x, int y, int w, int h, Color color );
  void drawRectangle(int x, int y, int w, int h, Color color);

}
