package model;

import java.util.Objects;

public class MoveMotion implements IMotion {
  //private final String shapeId;
  private final IModelShape shape;
  private final int sT;
  private final int eT;
  private final int sX;
  private final int eX;

  public MoveMotion(IModelShape shape, int sT, int eT, int sX, int eX) {
    this.shape = Objects.requireNonNull(shape);
    this.sT = sT;
    this.eT = eT;
    this.sX = sX;
    this.eX = eX;
  }

  @Override               //the tick could be any number.
  public IModelShape apply(int tick) {
    if ( tick < this.sT || tick > this.eT ){
      return null;
    }
    shape.setX(shape.getX() + tick);
    shape.setY(shape.getY() + tick);
    //shape.setW(shape.getW() + 5);
    return shape;
  }
}
