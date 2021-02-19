import static org.junit.Assert.*;

import java.awt.Point;
import model.ComplexTurtleGraphics;
import model.ITracingTurtleGraphics;
import model.ITurtleGraphics;
import model.SimpleTurtleModel;
import model.SuperSimpleTurtleGraphics;
import model.TracingTurtleGraphics;
import model.TracingTurtleGraphics2;
import org.junit.Test;

public class SimpleTurtleModelTest {
  @Test
  public void testSaveRetrieve(){
    ITurtleGraphics turtleGraphics = new SimpleTurtleModel();
    ITurtleGraphics superSimpleTurtleGraphics = new SuperSimpleTurtleGraphics();
    ITurtleGraphics complexTurtleGraphics = new ComplexTurtleGraphics();

    turtleGraphics.move(10); //(0,10), heading=0.
    turtleGraphics.retrieve(); //0,0

    assertEquals( new Point(0,0), turtleGraphics.getPosition());

  }

  @Test
  public void test2(){
    ITracingTurtleGraphics tracingTurtleGraphics = new TracingTurtleGraphics(); //inheritance
    ITracingTurtleGraphics tracingTurtleGraphicsDelegate = new TracingTurtleGraphics2( new SimpleTurtleModel());
  }
}