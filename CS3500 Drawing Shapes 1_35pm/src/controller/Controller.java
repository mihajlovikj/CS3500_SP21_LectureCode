package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.util.List;
import java.util.Objects;
import javax.swing.Timer;
import model.IModel;
import model.IModelShape;
import model.ModelRectangle;
import view.IView;

public class Controller implements IController, ActionListener{
  private final IView view;
  private final IModel model;
  private Timer timer;
  int tick = 1;
  public Controller(IView view, IModel model) {
    this.view = Objects.requireNonNull(view);
    this.model = Objects.requireNonNull(model);
  }

  @Override
  public void go() {
    this.tick = 0;
    view.render();

    timer = new Timer(10, this);


    timer.start();


  }

  @Override
  public void actionPerformed(ActionEvent e) {


    List<IModelShape> shapesToRender = model.getShapesAtTick(tick);

    for (IModelShape shape : shapesToRender) {
      switch ( shape.getType() ){
        case RECTANGLE:
          view.drawRectangle((int) shape.getBounds().getX(), (int) shape.getBounds().getY(),
              (int) shape.getBounds().getWidth(), (int) shape.getBounds().getHeight(),
              shape.getColor());
          break;
        case OVAL:
          view.drawEllipse((int) shape.getBounds().getX(), (int) shape.getBounds().getY(),
              (int) shape.getBounds().getWidth(), (int) shape.getBounds().getHeight(),
              shape.getColor());
          break;
      }
    }
    view.refresh();
    tick++;
  }
}
