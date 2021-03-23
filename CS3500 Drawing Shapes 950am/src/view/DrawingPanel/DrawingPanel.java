package view.DrawingPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

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
  }

  public void drawRectangle(int x, int y, int w, int h, Color color){
    this.shapes.add( new DrawingPanelRectangle(x,y,w,h, color) );
  }

  public void drawEllipse(int x, int y, int w, int h, Color color){
    this.shapes.add( new DrawingPanelEllipse(x,y,w,h, color) );
  }

  public void drawShape(IDrawingPanelShape shape){
    this.shapes.add( shape );
  }
}
