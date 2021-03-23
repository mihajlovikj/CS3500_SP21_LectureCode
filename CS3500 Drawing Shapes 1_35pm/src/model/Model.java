package model;

import java.awt.Color;
import java.awt.Shape;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Model implements IModel{
  private final Map<String, IModelShape > shapes;

  public Model() {
    this.shapes = new LinkedHashMap<String, IModelShape>();
  }


  @Override
  public void addRectangle(String id, int x, int y, int w, int h, Color color) {
    shapes.putIfAbsent(id, new ModelRectangle(x,y,w,h,color) );
  }

  @Override
  public void addEllipse(String id, int x, int y, int w, int h, Color color) {
    shapes.putIfAbsent(id, new ModelEllipse(x,y,w,h,color) );
  }

  //Maybe ok, maybe not.
  @Override
  public List<IModelShape> getShapesAtTick(int tick) {
    List<IModelShape> shapesToReturn = new ArrayList<IModelShape>();

    for ( IModelShape shape : shapes.values() ){
      shapesToReturn.add( shape.transform(tick) );
    }

    return shapesToReturn;
  }
}
