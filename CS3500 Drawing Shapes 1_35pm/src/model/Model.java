package model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Model implements IModel{
  private final Map<String, IMotionShape> shapes;
  private final List<IMotion> motions;
  public Model() {
    this.shapes = new LinkedHashMap<String, IMotionShape>();
    this.motions = new ArrayList<IMotion>();
  }


  @Override
  public void addRectangle(String id, int x, int y, int w, int h, Color color) {
    if ( x < 30 ){
      throw new IllegalArgumentException("x < 30");
    }
    shapes.putIfAbsent(id, new ModelRectangle(x,y,w,h,color) );
  }

  @Override
  public void addEllipse(String id, int x, int y, int w, int h, Color color) {
    shapes.putIfAbsent(id, new ModelEllipse(x,y,w,h,color) );
  }

  @Override
  public void addMoveMotion(String id, int sT, int eT, int sX, int eX) {
    this.motions.add( new MoveMotionX( this.shapes.get(id), sT, eT, sX, eX) );
  }

  @Override
  public void addWidthMotion(String id, int sT, int eT, int sW, int eW) {
    this.motions.add( new SizeMotion( this.shapes.get(id), sT, eT, sW, eW) );
  }

  @Override
  public void addMotion(String id, int sT, int x, int y, int w, int h, int r, int g, int b, int eT,
      int x1, int y1, int w1, int h1, int r1, int g1, int b1) {
      if ( x != x1 ){
        motions.add( new MoveMotionX( shapes.get(id), sT, eT, x, x1));
      }
      if ( y != y1 ){
        motions.add(new AbstractMotion( shapes.get(id),sT, eT, y, y1 ) {
          @Override
          public IReadOnlyModelShape apply(int tick) {
            if ( tick >= sT && tick <= eT ){
              shape.setY( tween (tick ) );
            }
            return null;
          }
        });
      }
  }

  //Maybe ok, maybe not.
  @Override
  public List<IReadOnlyModelShape> getShapesAtTick(int tick) {
    Set<IReadOnlyModelShape> shapesToReturn = new HashSet<IReadOnlyModelShape>();

    for ( IMotion motion : motions ){
      IReadOnlyModelShape transformedMotion = motion.apply(tick);//3 motions, 1 moveMotion on R1, 1 sizeMotion on R1, 1 move Motion on E1
      if ( transformedMotion != null ){
        shapesToReturn.add(transformedMotion);
      }
    }

    return new ArrayList<IReadOnlyModelShape>(shapesToReturn);
  }
}
