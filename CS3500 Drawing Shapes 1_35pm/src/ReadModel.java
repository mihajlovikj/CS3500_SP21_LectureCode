import java.awt.Color;
import model.IModel;
import model.Model;

public class ReadModel {
  public static IModel getModel(){
    //AnimationReader
    IModel model = new Model();
    model.addRectangle("R1", 40,40, 100, 100, Color.red);
    model.addEllipse("E1", 300,300,200,200, Color.CYAN);
                          //startTick   endTick     startX      endX
    model.addMotion("R1", 0,40,40,100,100,0,0,0, 100, 200,200,100,100,0,0,0);
//    model.addWidthMotion("R1", 0,         100,          100,      900);

 //   model.addMoveMotion("E1", 0,       100,         300,       500);
    return model;
  }
}
