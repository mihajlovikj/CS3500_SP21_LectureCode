package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import view.DrawingPanel.DrawingPanel;
import view.DrawingPanel.DrawingPanelEllipse;
import view.DrawingPanel.DrawingPanelRectangle;
import view.DrawingPanel.IDrawingPanelShape;

public class View extends JFrame implements IView{
  private final DrawingPanel drawingPanel;
  private final JButton start;
  public View(){
    super();
    setSize( new Dimension(800, 800));
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    drawingPanel = new DrawingPanel();
    start = new JButton("Start");
    setLayout( new BorderLayout() );
    add(drawingPanel, BorderLayout.CENTER);
    add(start, BorderLayout.PAGE_END);
  }
  @Override
  public void render() {
    setVisible(true);
  }

  @Override
  public void drawShape(IViewShape shape) {
    //the type of this shape is what?
    switch ( shape.getType() ){
      case RECTANGLE:
        this.drawingPanel.drawShape(  new DrawingPanelRectangle( shape.getX(), shape.getY(), shape.getW(), shape.getH(), shape.getColor()));
        break;
      case OVAL:
        this.drawingPanel.drawShape(  new DrawingPanelEllipse( shape.getX(), shape.getY(), shape.getW(), shape.getH(), shape.getColor()));
        break;
      case PATH:
        //this.drawingPanel.drawShape( new DrawingPanelPath( shape.getX(), shape.getY(), shape.getPoints() ));
        break;
    }
  }

  @Override
  public void drawEllipse(int x, int y, int w, int h, Color color) {
    this.drawingPanel.drawEllipse(x,y,w,h,color);
  }

  @Override
  public void drawRectangle(int x, int y, int w, int h, Color color) {
    this.drawingPanel.drawRectangle( x,y,w, h,color);
  }

  public void drawTriangle(int x, int y, int base, int height, Color color){
    this.drawingPanel.drawShape( new DrawingPanelRectangle(x,y,base, height, color, 2));
  }
}
