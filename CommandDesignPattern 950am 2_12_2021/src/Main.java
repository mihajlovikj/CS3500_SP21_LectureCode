import TracingModel.ITracingTurtleModel;
import TracingModel.TracingTurtleModel;
import controller.Controller;
import controller.IController;
import java.io.InputStreamReader;

public class Main {
  public static void main(String [] args){
    ITracingTurtleModel turtleModel = new TracingTurtleModel();
    IController controller = new Controller(turtleModel, new InputStreamReader(System.in), System.out);
    controller.go();
  }
}
