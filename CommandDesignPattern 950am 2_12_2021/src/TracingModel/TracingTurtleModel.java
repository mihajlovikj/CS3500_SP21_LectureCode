package TracingModel;

import SimpleModel.SimpleTurtleModel;
import java.awt.Point;
import java.awt.geom.Line2D;
import java.awt.geom.Line2D.Double;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

//Abstract Class => extension.
//Composition => delegation.
public class TracingTurtleModel extends SimpleTurtleModel implements ITracingTurtleModel{
  private final List<Line2D> lines;

  public TracingTurtleModel() {
    this.lines = new ArrayList<Line2D>();
  }

  @Override
  public void trace(double distance) {
    //this.stackPositions.isEmpty();
    Point start = this.getPosition();
    this.move(distance);
    Point end = this.getPosition();
    this.lines.add( new Line2D.Double( start, end) );
  }

  @Override
  public List<Line2D> getLines() {
    List<Line2D> lines = new ArrayList<Line2D>();
    for ( Line2D line : this.lines ){
      lines.add( new Line2D.Double( new Point2D.Double( line.getP1().getX(), line.getP1().getY() ),
                 new Point2D.Double( line.getP2().getX(), line.getP2().getY() ) ));
    }
    return lines;
  }








}
