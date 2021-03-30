package model;

import java.util.Objects;

public class MoveMotionX extends AbstractMotion{
  public MoveMotionX(IMotionShape shape, int sT, int eT, int sX, int eX) {
   super( shape, sT, eT, sX, eX);
  }

  @Override
  public IReadOnlyModelShape apply(int tick) {
    if ( tick >= sT && tick <= eT){
      shape.setX( tween(tick) );
      return shape;
    }
    return null;
  }
}
