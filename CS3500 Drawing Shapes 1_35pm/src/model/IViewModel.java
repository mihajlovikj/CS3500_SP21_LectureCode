package model;

import java.awt.Shape;
import java.util.List;

public interface IViewModel {
  List<IModelShape> getShapesAtTick(int tick);
}
