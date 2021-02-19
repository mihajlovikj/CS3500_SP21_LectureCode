package model;

import java.awt.Point;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;

public class TracingTurtleGraphics extends SimpleTurtleModel implements ITracingTurtleGraphics{
  private final List<Line2D> lines;
  //3 things:
  //Extend the model.SimpleTurtleModel (inheritance)
  //Delegation ( composition )
  //Abstract class.
  public TracingTurtleGraphics(){
    super();
    this.
    lines = new ArrayList<>();
  }
  @Override
  public void trace(double distance) {
    Point start = this.getPosition(); //0x100
    this.move(distance);
    Point end = this.getPosition(); //0x200
    lines.add( new Line2D.Double( start, end) );
  }

  @Override
  public List<Line2D> getLines() {
    List<Line2D> lines = new ArrayList<>();
    for ( Line2D line : lines ){
      lines.add( new Line2D.Double(  new Point( (int)line.getX1(), (int)line.getX2()),
                                     new Point((int)line.getX2(), (int)line.getY2())));
    }
    return new ArrayList<>(lines);
  }
}
