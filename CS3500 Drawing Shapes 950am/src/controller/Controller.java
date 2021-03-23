package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import javax.swing.Timer;
import model.IModel;
import model.IModelShape;
import model.IViewOnlyModelShape;
import view.IView;

public class Controller implements IController{
  private final IView view;
  private final IModel model;
  private  Timer timer;
  public Controller(IView view, IModel model) {
    this.view = Objects.requireNonNull(view);
    this.model = Objects.requireNonNull(model);

    timer = new Timer(300, new ActionListener() {
      int tick = 1;
      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println(tick);
        for (IViewOnlyModelShape modelShape : model.getShapesAtTick(tick) ){
          switch ( modelShape.getType() ){
            case RECTANGLE:
              view.drawRectangle(modelShape.getX(),modelShape.getY(),modelShape.getW(),modelShape.getH(), modelShape.getColor());
              break;
            case OVAL:
              view.drawEllipse(modelShape.getX(),modelShape.getY(),modelShape.getW(),modelShape.getH(), modelShape.getColor());

              break;
          }
        }
        tick++;
      }
    });
  }


  @Override
  public void go() {
    timer.start();
    this.view.render();

  }
}
