package model;

import java.awt.Point;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TracingTurtleGraphics2 implements ITracingTurtleGraphics{
  private final ITurtleGraphics delegate;
  private final List<Line2D> lines;

  public TracingTurtleGraphics2(ITurtleGraphics delegate) {
    this.delegate = Objects.requireNonNull(delegate);
    this.lines = new ArrayList<>();
  }

  public TracingTurtleGraphics2() {
    this.delegate = new SimpleTurtleModel();
    this.lines = new ArrayList<>();
  }

  @Override
  public void trace(double distance) {
    Point start = this.getPosition(); //0x100
    this.delegate.move(distance);
    Point end = this.delegate.getPosition(); //0x200
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
