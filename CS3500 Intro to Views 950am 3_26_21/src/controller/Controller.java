package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Objects;
import java.util.Random;
import javax.swing.Timer;
import model.IModel;
import model.IViewOnlyModelShape;
import view.IView;
import view.ViewFeaturesListener;

public class Controller implements IController, ViewFeaturesListener {
  private final IView view;
  private final IModel model;
  private  Timer timer;
  private int shapeCounter;
  public Controller(IView view, IModel model) {
    this.view = Objects.requireNonNull(view);
    this.model = Objects.requireNonNull(model);
    this.view.addListener(this);
    this.shapeCounter = 0;

  }


  @Override
  public void go(int tickRate) {
    timer = new Timer((int)(1000.0/tickRate), new ActionListener() {
      int tick = 1;
      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println(tick);
        for (IViewOnlyModelShape modelShape : model.getShapesAtTick(tick) ){
          //IModelShape shape = (IModelShape)modelShape;

          switch ( modelShape.getType() ){
            case RECTANGLE:
              view.drawRectangle(modelShape.getX(),modelShape.getY(),modelShape.getW(),modelShape.getH(), modelShape.getColor());
              break;
            case OVAL:
              view.drawEllipse(modelShape.getX(),modelShape.getY(),modelShape.getW(),modelShape.getH(), modelShape.getColor());

              break;
          }
        }
//        if ( tick == 10)
//          timer.stop();

        view.refresh();
        tick++;
      }
    });

    timer.start();
    this.view.render();

  }

  @Override
  public void handleAddShape(int x, int y) {
    System.out.println("Responding to adding a shape request");
    String id = "CR" + shapeCounter;
    //try to satisfy the request.
    try {
      model.addRectangle(id, x, y, x, y, Color.red);
      model.addMoveMotion(id, 0, 100, x, x+1000);
      shapeCounter++;
    }catch (IllegalArgumentException e){
      view.displayError(e.getMessage());
    }

  }

  @Override
  public void handleRemoveShape() {
    System.out.println("remove some shape?");
    //model.removeShape();
  }

  @Override
  public void handleSaveEvent() {
    //emitError might display a JWindow error.
    //view.emitError("handleSave is not supported.")
  }

  @Override
  public void handleLoadEvent() {
    //This is not supported.
  }

  @Override
  public void handleSelectColorEvent() {

  }

  @Override
  public void handleClear() {

  }
}
