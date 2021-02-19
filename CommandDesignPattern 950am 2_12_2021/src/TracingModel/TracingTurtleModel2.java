package TracingModel;

import SimpleModel.ITurtleModel;
import SimpleModel.SimpleTurtleModel;
import java.awt.Point;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TracingTurtleModel2 implements ITracingTurtleModel{
  private final ITurtleModel delegate;
  private final List<Line2D> lines;
  public TracingTurtleModel2() {
    this.delegate = new SimpleTurtleModel();
    this.lines = new ArrayList<Line2D>();
  }

  public TracingTurtleModel2(ITurtleModel delegate) {
    this.delegate = Objects.requireNonNull(delegate);
    this.lines = new ArrayList<Line2D>();
  }

  @Override
  public void trace(double distance) {
    Point start = this.delegate.getPosition();
    this.delegate.move(distance);
    Point end = this.delegate.getPosition();
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

  @Override
  public void move(double distance) {
    this.delegate.move(distance);
  }

  @Override
  public void turn(double angle) {
    this.delegate.turn(angle);
  }

  @Override
  public void save() {
    this.delegate.save();
  }

  @Override
  public void retrieve() {
    this.delegate.retrieve();
  }

  @Override
  public Point getPosition() {
    return this.delegate.getPosition();
  }
}
