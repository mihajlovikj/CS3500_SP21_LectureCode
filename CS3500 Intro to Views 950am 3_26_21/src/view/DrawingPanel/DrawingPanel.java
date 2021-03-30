package view.DrawingPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.swing.JPanel;

public class DrawingPanel extends JPanel {
  private final List<IDrawingPanelShape> shapes;
  public DrawingPanel(){
    super();
    setBackground(Color.yellow);
    shapes = new ArrayList<IDrawingPanelShape>();
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    for ( IDrawingPanelShape shape : shapes ){
     shape.draw(g);
    }

    shapes.clear();
  }

  public void drawRectangle(int x, int y, int w, int h, Color color){
    this.shapes.add( new DrawingPanelRectangle(x,y,w,h, color) );
  }

  public void drawEllipse(int x, int y, int w, int h, Color color){
    this.shapes.add( new DrawingPanelEllipse(x,y,w,h, color) );
  }

  public void drawShape(IDrawingPanelShape shape){
    this.shapes.add( shape );
  }

//  public void addMouseListener(MouseListener listener){
//    this.addMouseListener(Objects.requireNonNull(listener));
//  }

//  @Override
//  public void mouseClicked(MouseEvent e) {
//    System.out.println(e.getPoint());
//  }
//
//  @Override
//  public void mousePressed(MouseEvent e) {
//
//  }
//
//  @Override
//  public void mouseReleased(MouseEvent e) {
//
//  }
//
//  @Override
//  public void mouseEntered(MouseEvent e) {
//
//  }
//
//  @Override
//  public void mouseExited(MouseEvent e) {
//
//  }
}
