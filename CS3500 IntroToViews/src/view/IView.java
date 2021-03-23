package view;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

public interface IView {
  //Displays the view.
  void render();
  void addListners(ActionListener listener, KeyListener keyListener);
  String getText();
  void setMessage(String message);

}
