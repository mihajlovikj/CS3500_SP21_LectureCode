import controller.Controller;
import controller.IController;
import java.io.InputStreamReader;
import javax.print.DocFlavor.INPUT_STREAM;
import model.ITracingTurtleGraphics;
import model.TracingTurtleGraphics;

public class Main {
  public static void main(String [] args){
    ITracingTurtleGraphics tracingTurtleGraphics = new TracingTurtleGraphics();
    IController controller = new Controller(tracingTurtleGraphics,
                                            System.out, new InputStreamReader(System.in) );

    controller.go();
  }
}
