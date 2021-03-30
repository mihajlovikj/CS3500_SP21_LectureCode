import controller.Controller;
import controller.IController;
import java.io.File;
import model.IModel;
import model.ReadModel;
import view.TextView;
import view.IGeneralView;
import view.IView;
import view.View;

public class main {
  public static void main(String [] args){
    IModel model = ReadModel.readFromFile(new File("bigBang.txt"));
    IView view = new View(400,400, 800, 800, 4000,4000 );
    IGeneralView textView = new TextView();
    IController controller = new Controller(view, model);
    controller.go( 5 );
  }
}
