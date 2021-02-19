package controller;

import static org.junit.Assert.*;

import java.io.StringReader;
import model.ITracingTurtleGraphics;
import model.TracingTurtleGraphics;
import org.junit.Test;

public class ControllerTest {

  @Test
  public void go() {
    ITracingTurtleGraphics tracingTurtleGraphics = new TracingTurtleGraphics();
    Appendable stringBuilder = new StringBuilder();
    Readable stringReader = new StringReader("move 10 turn 90");//Single line? or not?
    IController controller = new Controller(tracingTurtleGraphics, stringBuilder, stringReader);
    controller.go();

    assertEquals("", stringBuilder.toString() );
  }
}