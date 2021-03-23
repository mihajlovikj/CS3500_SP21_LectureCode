package view.DrawingPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Ellipse2D;
import java.util.Objects;

public class DrawingPanelEllipse extends Ellipse2D.Float implements IDrawingPanelShape {
  private final Color color;
  public DrawingPanelEllipse(int x, int y, int w, int h, Color color){
    super(x,y,w,h);
    this.color = color;
  }
  @Override
  public void draw(Graphics g) {
    Objects.requireNonNull(g);

    g.setColor(this.color);
    g.fillOval((int)x,(int)y,(int)width,(int)height);
  }
}
