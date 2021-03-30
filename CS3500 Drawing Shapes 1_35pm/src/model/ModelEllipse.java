package model;

import java.awt.Color;
import java.awt.geom.Ellipse2D;

public class ModelEllipse extends Ellipse2D.Float implements IMotionShape {
  private final Color color;

  public ModelEllipse(int x, int y, int w, int h, Color color) {
    super(x, y, w, h);
    this.color = color;
  }

  @Override
  public Color getColor() {
    return color;
  }

  @Override
  public ModelShapeType getType() {
    return ModelShapeType.OVAL;
  }

  @Override
  public IReadOnlyModelShape makeShape(int x, int y, int w, int h, Color color) {
    return new ModelEllipse(x, y, w, h, color);
  }

  @Override
  public void setX(int x) {
    this.x = x;
  }

  @Override
  public void setY(int y) {
    this.y = y;
  }

  @Override
  public void setW(int w) {
    this.width = w;
  }

  @Override
  public void setH(int h) {
    this.height = h;
  }
}
