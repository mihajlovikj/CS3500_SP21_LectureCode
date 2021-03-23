import controller.Controller;
import controller.IController;
import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.util.List;
import model.IModel;
import model.IModelShape;
import model.Model;
import model.ModelRectangle;
import view.IView;
import view.View;

public class Main {
  public static void main(String [] args){
    IView view = new View();
    IModel model = ReadModel.getModel();

    IController controller = new Controller(view, model);
    controller.go();
  }
}
