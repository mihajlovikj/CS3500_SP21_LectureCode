package view.DrawingPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Objects;

public class DrawingPanelRectangle extends Rectangle implements IDrawingPanelShape{
  private final Color color;
  private int borderThicknes;
  public DrawingPanelRectangle(int x, int y, int w, int h, Color color){
    super(x,y,w,h);
    this.color = color;
    this.borderThicknes = 0;
  }

  public DrawingPanelRectangle(int x, int y, int w, int h, Color color, int borderThickness){
    this(x,y,w,h, color);
    this.borderThicknes = borderThickness;

  }

  @Override
  public void draw(Graphics g) {
    Objects.requireNonNull(g);

    g.setColor(this.color);
    g.fillRect(x, y, width, height);
  }
}
