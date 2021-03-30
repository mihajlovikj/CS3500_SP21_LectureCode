package model;

import java.awt.Color;

public class ModelRectangle implements IModelShape{
  private int x, y, w, h;
  private Color color;
  public ModelRectangle(int x, int y, int w, int h, Color color){
    this.x = x;
    this.y = y;
    this.w = w;
    this.h = h;
    this.color = color;
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
    this.w = w;
  }

  @Override
  public void setH(int h) {
    this.h = h;
  }

  @Override
  public ModelShapeType getType() {
    return ModelShapeType.RECTANGLE;
  }

  @Override
  public int getX() {
    return x;
  }

  @Override
  public int getY() {
    return y;
  }

  @Override
  public int getW() {
    return w;
  }

  @Override
  public int getH() {
    return h;
  }

  @Override
  public Color getColor() {
    return color;
  }
}
