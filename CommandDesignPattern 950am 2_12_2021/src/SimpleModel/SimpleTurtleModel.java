package SimpleModel;

import java.awt.Point;
import java.util.Stack;

public class SimpleTurtleModel implements ITurtleModel{
  private Point currentPosition;
  private double heading;
  private final Stack<Point> stackPositions;
  private final Stack<Double> headings;
  public SimpleTurtleModel() {
    this.currentPosition = new Point(0,0); //0x100
    this.heading = 0;
    this.stackPositions = new Stack<Point>();
    this.headings = new Stack<Double>();
  }

  //SOH CAH TOA
  @Override
  public void move(double distance) {
    int x = (int)(distance * Math.cos( Math.toRadians(this.heading)));
    int y = (int)(distance * Math.sin( Math.toRadians(this.heading)));

    //Do I create new position. Or do I mutate the existing one.
    //TODO: this might mess things up.
    this.currentPosition = new Point( (int)this.currentPosition.getX() + x,
                                      (int)this.currentPosition.getY() + y  );
//    this.currentPosition.setLocation(this.currentPosition.getX() + x,
//                                     this.currentPosition.getY() + y  );

    //this.0x100.setLocation(0,10);
  }

  @Override
  public void turn(double angle) {
    this.heading += angle;
  }

  @Override
  public void save() {
    //TODO: think if this will cause a bug!
    //Should we push a deep copy? Think about what we are pushing!
    this.stackPositions.push( this.currentPosition );//this.stackPositions.push(0x100);
    this.headings.push(this.heading);
  }

  @Override
  public void retrieve() {
    if ( this.stackPositions.isEmpty() || this.headings.isEmpty() ){
      throw new IllegalArgumentException("Nothing to retrieve.");
    }

    this.currentPosition = stackPositions.pop();
    this.heading = headings.pop();
  }

  @Override
  public Point getPosition() {
    //Introduce a bug! TODO:  how is this a bug?
    return new Point(this.currentPosition);
  }
}
