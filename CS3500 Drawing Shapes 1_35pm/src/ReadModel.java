import java.awt.Color;
import model.IModel;
import model.Model;

public class ReadModel {
  public static IModel getModel(){
    IModel model = new Model();
    model.addRectangle("R1", 0,0, 100, 100, Color.red);
    model.addEllipse("E1", 300,300,200,200, Color.CYAN);
    return model;
  }
}
