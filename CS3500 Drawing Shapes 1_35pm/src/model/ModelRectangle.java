package model;

import java.awt.Color;
import java.awt.Rectangle;

public class ModelRectangle extends Rectangle implements IMotionShape {
  private final Color color;

  public ModelRectangle(int x, int y, int w, int h, Color color) {
    super(x, y, w, h);
    this.color = color;
  }

  @Override
  public Color getColor() {
    return color;
  }


  @Override
  public ModelShapeType getType() {
    return ModelShapeType.RECTANGLE;
  }

  @Override
  public IReadOnlyModelShape makeShape(int x, int y, int w, int h, Color color) {
    return new ModelRectangle(x, y, w, h, color);
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
