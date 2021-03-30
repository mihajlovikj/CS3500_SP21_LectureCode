import controller.Controller;
import controller.IController;
import model.IModel;
import view.IView;
import view.View;

public class Main {
  public static void main(String [] args){
    IView view = new View(800,800);
    IModel model = ReadModel.getModel();

    IController controller = new Controller(view, model);
    controller.go();
  }
}
