package model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Model implements IModel{
  private final Map<String, IModelShape> shapes;
  private final List<IMotion> motions;
  //preserves the order in which the shapes were added.

  public Model() {
    this.shapes = new LinkedHashMap<>();
    this.motions = new ArrayList<IMotion>();
  }

  @Override
  public void addRectangle(String id, int x, int y, int w, int h, Color color) {
    if ( x < 50 ){
      throw new IllegalArgumentException("Cannot add shapes with x < 50");
    }
    shapes.putIfAbsent(id, new ModelRectangle(x,y,w,h, color) );
  }

  @Override
  public void addMoveMotion(String id, int sT, int eT, int sX, int eX) {
    this.motions.add( new MoveMotion( this.shapes.get(id), sT, eT, sX, eX) );
  }

  @Override
  public List<IViewOnlyModelShape> getShapesAtTick(int tick) {
    List<IViewOnlyModelShape> shapesToReturn = new ArrayList<>();

    for ( IMotion motion : this.motions ){
      IViewOnlyModelShape shape = motion.apply(tick); //mutate the paramters of the shape.
      if ( shape != null)
        shapesToReturn.add(shape);
    }
    return shapesToReturn;
  }
}
