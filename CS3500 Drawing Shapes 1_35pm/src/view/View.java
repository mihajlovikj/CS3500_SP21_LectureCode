package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class View extends JFrame implements IView {
  private final DrawingPanel drawingPanel;
  private final JButton startAnimation;
  public View(){
    super();

    setSize(new Dimension(800, 800));
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    drawingPanel = new DrawingPanel();
    startAnimation = new JButton("Start");
    setLayout( new BorderLayout());
    add(drawingPanel, BorderLayout.CENTER);
    add(startAnimation, BorderLayout.PAGE_END);
  }

  @Override
  public void render() {
    setVisible(true);
  }

  @Override
  public void drawEllipse(int x, int y, int w, int h, Color color) {
    this.drawingPanel.drawEllipse(x, y, w, h, color);
  }

  @Override
  public void drawRectangle(int x, int y, int w, int h, Color color) {
    this.drawingPanel.drawRectangle(x,y,w,h,color);
  }

  @Override
  public void refresh() {
    repaint();
  }


}
