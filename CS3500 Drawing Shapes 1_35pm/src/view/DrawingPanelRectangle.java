package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Objects;

public class DrawingPanelRectangle extends Rectangle implements IDrawingPanelShape {
  private final Color color;
  public DrawingPanelRectangle(int x, int y, int width, int height, Color color){
    super(x, y, width, height);
    this.color = Objects.requireNonNull(color);
  }


  @Override
  public void draw(Graphics g) {
    Objects.requireNonNull(g);

    g.setColor(this.color);
    g.fillRect( x, y, width, height );
  }
}
