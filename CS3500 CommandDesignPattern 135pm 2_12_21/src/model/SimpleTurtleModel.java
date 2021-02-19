package model;

import java.awt.Point;
import java.util.Stack;

public class SimpleTurtleModel implements ITurtleGraphics{
  private Point currentPosition;
  private double currentHeading;
  private final Stack<Point> savedPositions;
  private final Stack<Double> savedHeadings;
  public SimpleTurtleModel() {
    this.currentPosition = new Point(0,0); //this.currentPosition = 0x100;
    this.currentHeading = 0;
    this.savedHeadings = new Stack<>();
    this.savedPositions = new Stack<>();
  }
  //SOH CAH TOA
  @Override
  public void move(double distance) {
    //We need to update the current position based on the current position,
    //them move distance and the angle.
    int x = (int)(distance * Math.cos( Math.toRadians(currentHeading) ));
    int y = (int)(distance * Math.sin( Math.toRadians(currentHeading)));
                            //0x200
    this.currentPosition = new Point( (int)this.currentPosition.getX() + x,
                                      (int)this.currentPosition.getY() + y);

    //0x100

//    this.currentPosition.setLocation( this.currentPosition.getX() + x,
//                                      this.currentPosition.getY() + y);
//
    //this.0x100.setLocation( 0, 30 );
  }

  @Override
  public void turn(double angle) {
    this.currentHeading += angle;
  }

  /*

        0x200; (0,20)
        0x100; (0,30)
   */
  @Override
  public void save() {
    this.savedPositions.push( this.currentPosition );
    //this.savedPositions.push( 0x100 );
    this.savedHeadings.push(this.currentHeading);
  }

  @Override
  public void retrieve() {
    if ( savedPositions.isEmpty() || savedHeadings.isEmpty() ){
      throw new IllegalStateException("Nothing to retrieve.");
    }
    this.currentPosition.setLocation( this.savedPositions.pop() );
    //this.currentPosition = 0x100;
    this.currentHeading = this.savedHeadings.pop();
  }

  @Override
  public Point getPosition() {
    return new Point(this.currentPosition);
  }
}
