package view;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import view.DrawingPanel.IDrawingPanelShape;

public interface IView extends IGeneralView{
  void drawShape( IViewShape shape);
  void drawEllipse( int x, int y, int w, int h, Color color );
  void drawRectangle(int x, int y, int w, int h, Color color);
  void refresh();
  void addListener(ViewFeaturesListener listener);
  void displayError(String message);
}
