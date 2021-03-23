package model;

import java.awt.Color;
import java.awt.Rectangle;

public class ModelRectangle extends Rectangle implements IModelShape{
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
  public IModelShape transform(int tick) {
    return new ModelRectangle((int)this.x + tick*2, (int)this.y + tick*2, (int)this.width, (int)this.height, this.color);
  }

  @Override
  public ModelShapeType getType() {
    return ModelShapeType.RECTANGLE;
  }
}
