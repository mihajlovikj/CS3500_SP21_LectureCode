import static org.junit.Assert.*;

import SimpleModel.ITurtleModel;
import SimpleModel.SimpleTurtleModel;
import SimpleModel.SuperSimpleTurtleModel;
import TracingModel.ITracingTurtleModel;
import TracingModel.TracingTurtleModel;
import TracingModel.TracingTurtleModel2;
import java.awt.Point;
import org.junit.Test;

public class SimpleTurtleModelTest {
  /*
                                          |
                                          |
       currentPos = (0,0);            ____|
   */
  @Test
  public void test1(){
    ITurtleModel turtleModel = new SimpleTurtleModel();
    Point currentPos = turtleModel.getPosition();

    /*
        0x100 (10,10)
        0x100 (10,10)
        0x100 (10,10);
     */
    turtleModel.save(); //this.stackPositions.push(0x100);
    turtleModel.move(10);//0x100.setLocation(0,10);
    turtleModel.save();//this.stackPositions.push(0x100);
    turtleModel.turn(90);
    turtleModel.move(10);//0x100.setLocation(10,10);
    turtleModel.save();//this.stackPositions.push(0x100);
    turtleModel.retrieve();
    turtleModel.retrieve();
    turtleModel.retrieve();

    assertEquals( new Point(0,0), turtleModel.getPosition());
  }

  protected void helper(ITurtleModel model){

  }

  @Test
  public void test2(){
    ITracingTurtleModel model = new TracingTurtleModel();
    ITurtleModel iTurtleModel = model;
    model.trace(3);
    //iTurtleModel.trace(3);
    ITracingTurtleModel model2 = new TracingTurtleModel2( new SimpleTurtleModel() );
    ITracingTurtleModel model3 = new TracingTurtleModel2( new SuperSimpleTurtleModel() );
    helper(model);
  }
}