package TracingModel;

import SimpleModel.ITurtleModel;
import java.awt.geom.Line2D;
import java.util.List;

public interface ITracingTurtleModel extends ITurtleModel {
  void trace(double distance);
  List<Line2D> getLines();
}
