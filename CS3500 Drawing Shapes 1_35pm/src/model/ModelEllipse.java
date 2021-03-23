package model;

import java.awt.Color;
import java.awt.geom.Ellipse2D;

public class ModelEllipse extends Ellipse2D.Float implements IModelShape {
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
  public IModelShape transform(int tick) {
    return new ModelEllipse((int)this.x + tick*2, (int)this.y + tick*2, (int)this.width, (int)this.height, this.color);
  }

  @Override
  public ModelShapeType getType() {
    return ModelShapeType.OVAL;
  }
}
