package view;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class MyDrawingPanel extends JPanel {
  public MyDrawingPanel(){
    super();
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    g.setColor(Color.BLACK);
    g.fillOval(100,100,300,300);
  }

//  void drawOval(){...}
//  void drawRect(){...}
}
