package model;

import java.util.Objects;

public abstract class AbstractMotion implements IMotion{
  final protected IMotionShape shape;
  final protected int sT;
  final protected int eT;
  final protected int startParam;
  final protected int endParam;

  public AbstractMotion(IMotionShape shape, int sT, int eT, int startParam, int endParam) {
    this.shape = Objects.requireNonNull(shape);
    if ( eT < sT ){
      throw new IllegalArgumentException("eT > sT");
    }
    this.sT = sT;
    this.eT = eT;
    this.startParam = startParam;
    this.endParam = endParam;
  }
  @Override
  public abstract IReadOnlyModelShape apply(int tick);

  protected int tween(int tick){
    return startParam + tick*2; //tweening.
  }
}
