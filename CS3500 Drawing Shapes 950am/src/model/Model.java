package model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Model implements IModel{

  @Override
  public void addRectangle(int x, int y, int w, int h, Color color) {

  }

  @Override
  public void addEllipse(int x, int y, int w, int h, Color color) {

  }

  @Override
  public List<IViewOnlyModelShape> getShapesAtTick(int tick) {
    List<IViewOnlyModelShape> shapesToReturn = new ArrayList<>();
    shapesToReturn.add( new ModelRectangle(5*tick,5*tick,50,50, Color.green));
    shapesToReturn.add( new ModelRectangle(150*tick,150*tick,50,50, Color.cyan));
    return shapesToReturn;
  }
}
