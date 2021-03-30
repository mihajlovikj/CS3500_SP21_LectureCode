package model;

import java.awt.Color;
import java.io.File;

public class ReadModel {
  public static IModel readFromFile(File file){
    IModel model = new Model();
    model.addRectangle("R1", 60, 60, 100,100, Color.green);
    model.addRectangle("R2", 100, 400, 50,50, Color.cyan);
                          //start, end  startx  startY
    model.addMoveMotion("R1", 0,   100,   0,     300);
    model.addMoveMotion("R2", 10,   20,   100,     300);
    return model;
  }
}
