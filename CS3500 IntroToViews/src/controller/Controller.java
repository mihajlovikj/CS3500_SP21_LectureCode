package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Objects;
import model.IModel;
import view.IView;
import view.MyView;

public class Controller implements IController, ActionListener, KeyListener, MouseListener {
  private final IView view;
  private final IModel model;

  public Controller(IView view, IModel model) {
    this.view = Objects.requireNonNull(view);
    this.model = Objects.requireNonNull(model);
    this.view.addListners(this, this);
    //timer, java.util.Timer; java.awt.swing.timer;
  }


  @Override
  public void go() {
    this.view.render();
  }

  private void handleSubmitEvent(){
    String typedText = this.view.getText();
    model.setUsername( typedText );
    this.view.setMessage( "Model updated." );
  }

  private void handleRefreshEvent(){
    String username = model.getUsername();
    this.view.setMessage( username.toUpperCase() );
    //make sure you update the phone view.
    //I would like to retrieve the username from the model.
  }
  @Override
  public void actionPerformed(ActionEvent e) {
    //The actionPerfromed needs to have access to my model.
    switch ( e.getActionCommand() ){
      case "submit":
        handleSubmitEvent();
        break;
      case "refresh":
        handleRefreshEvent();
        break;
    }
  }

  @Override
  public void keyTyped(KeyEvent e) {
    if ( e.getKeyChar() == '\n'){
      handleSubmitEvent();
    }
  }

  @Override
  public void keyPressed(KeyEvent e) {

  }

  @Override
  public void keyReleased(KeyEvent e) {

  }

  @Override
  public void mouseClicked(MouseEvent e) {

  }

  @Override
  public void mousePressed(MouseEvent e) {

  }

  @Override
  public void mouseReleased(MouseEvent e) {

  }

  @Override
  public void mouseEntered(MouseEvent e) {

  }

  @Override
  public void mouseExited(MouseEvent e) {

  }
}
