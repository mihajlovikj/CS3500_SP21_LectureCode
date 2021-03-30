package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import javax.swing.Timer;
import model.IModel;
import model.IReadOnlyModelShape;
import view.IView;
import view.ViewListner;

public class Controller implements IController, ViewListner {
  private final IView view;
  private final IModel model;
  private Timer timer;
  private int counter;
  int tick = 1;
  public Controller(IView view, IModel model) {
    this.view = Objects.requireNonNull(view);
    this.model = Objects.requireNonNull(model);
    this.view.addListener(this);
    this.counter = 0;
  }

  @Override
  public void go() {
    this.tick = 0;
    view.render();
    timer = new Timer(1000, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        List<IReadOnlyModelShape> shapesToRender = model.getShapesAtTick(tick);
        for (IReadOnlyModelShape shape : shapesToRender) {
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
        view.refresh();//repaints.
        tick++;
      }
    });
    timer.start();


  }

  @Override
  public void shapeAddedEvent(int x, int y) {
    String id = "RR" + counter++;
    //This could fail!
    try {
      model.addRectangle(id, x, y, 50, 50, Color.red);
      model.addMotion(id, 0, x, y, 50, 50, 0, 0, 0, 100, 500, 500, 100, 100, 0, 0, 0);
      this.view.resetFocus();
    } catch (IllegalArgumentException e){
      //Avoid silently ignoring errors
      view.displayError( e.getMessage() );
    }
  }

  @Override
  public void shapeRemovedEvent() {

  }

  @Override
  public void saveEvent() {

  }

  @Override
  public void loadEvent() {

  }

  @Override
  public void motionAddedEvent() {

  }
}
