package model;

public class SizeMotion extends AbstractMotion{
  public SizeMotion(IMotionShape shape, int sT, int eT, int sW, int eW) {
    super(shape, sT, eT, sW, eW);
  }

  @Override
  public IReadOnlyModelShape apply(int tick) {
    if ( tick >= sT && tick <= eT) {
      shape.setW((int) shape.getBounds().getWidth() + tick * 5);
      return shape;
    }
    return null;
  }
}
