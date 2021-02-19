package controller;

import static org.junit.Assert.*;

import TracingModel.ITracingTurtleModel;
import TracingModel.TracingTurtleModel;
import java.awt.Point;
import java.io.StringReader;
import java.util.Scanner;
import org.junit.Test;

public class ControllerTest {

  @Test
  public void go() {
    ITracingTurtleModel model = new TracingTurtleModel();
    StringReader reader = new StringReader("square 3 q");
    StringBuilder stringBuilder = new StringBuilder();
    IController controller = new Controller(model, reader, stringBuilder);

    controller.go();

    assertEquals("Printing: Moving\nPrinting: Quitting", stringBuilder.toString());
  }

  @Test
  public void go2(){
    ITracingTurtleModel model = new TracingTurtleModel();
    StringReader reader = new StringReader("move 1");
    StringBuilder stringBuilder = new StringBuilder();
    IController controller = new NewController(model, reader, stringBuilder);

    controller.go();

    assertEquals("Printing: Moving\nPrinting: Quitting", stringBuilder.toString());
  }

  @Test
  public void testMoveCommand(){
    ITracingTurtleModel model = new TracingTurtleModel();
    StringReader reader = new StringReader("move 1");
    StringBuilder stringBuilder = new StringBuilder();

    ICommand moveCommand = new MoveCommand(model, stringBuilder);
    Scanner scanner = new Scanner(reader);
    moveCommand.run(scanner);
    assertEquals( new Point(0,10), model.getPosition() );
  }
}