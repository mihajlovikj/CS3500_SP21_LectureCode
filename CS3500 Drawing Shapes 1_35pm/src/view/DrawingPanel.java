package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Float;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JPanel;
//For the time being, I will have just a class, since we don't know what to put in the interface.
public class DrawingPanel extends JPanel {
  private final List<IDrawingPanelShape> shapes;
  public DrawingPanel(){
    super();
    setBackground(Color.yellow);
    shapes = new ArrayList<IDrawingPanelShape>();
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    for ( IDrawingPanelShape shape : shapes ){
     shape.draw(g);
    }

    shapes.clear();
  }

  void drawEllipse(int x, int y, int w, int h, Color color){
    shapes.add( new DrawingPanelEllipse(x, y,w,h, color ) );
  }

  void drawRectangle(int x, int y, int w, int h, Color color){
    shapes.add( new DrawingPanelRectangle(x, y,w,h, color ) );
  }
}
