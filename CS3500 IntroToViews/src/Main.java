import controller.Controller;
import controller.IController;
import model.IModel;
import model.Model;
import view.IView;
import view.MyView;

public class Main {
  public static void main(String [] args){
    IModel model = new Model();
    IView view = new MyView();
    IController controller = new Controller(view, model);
    controller.go();//this will display the window.
  }
}
