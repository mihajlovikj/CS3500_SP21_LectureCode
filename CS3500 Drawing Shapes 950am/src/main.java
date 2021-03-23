import controller.Controller;
import controller.IController;
import java.awt.Color;
import model.IModel;
import model.Model;
import view.IView;
import view.View;

public class main {
  public static void main(String [] args){
    IView view = new View();
    IModel model = new Model();
    IController controller = new Controller(view, model);
   controller.go();
  }
}
