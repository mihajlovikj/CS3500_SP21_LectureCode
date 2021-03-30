package model;

public interface IMotion {
  IReadOnlyModelShape apply(int tick);
}
