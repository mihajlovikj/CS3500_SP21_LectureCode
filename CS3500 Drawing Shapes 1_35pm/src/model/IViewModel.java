package model;

import java.util.List;

public interface IViewModel {
  List<IReadOnlyModelShape> getShapesAtTick(int tick);
}
