package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import view.DrawingPanel.DrawingPanel;
import view.DrawingPanel.DrawingPanelEllipse;
import view.DrawingPanel.DrawingPanelRectangle;

public class View extends JFrame implements IView, ActionListener, KeyListener, MouseListener {
  private final DrawingPanel drawingPanel;
  private final JScrollPane scrollPane;
  private final JButton addRandomShape;
  private final List<ViewFeaturesListener> listenerList;
  public View(int x, int y, int w, int h,  int wD, int hD){
    super();
    setSize( new Dimension(w, h));
    setLocation(x,y);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    listenerList = new ArrayList<>();
    drawingPanel = new DrawingPanel();
    drawingPanel.addMouseListener(this);
    drawingPanel.setPreferredSize( new Dimension(wD,hD));
    scrollPane = new JScrollPane(drawingPanel);//decorator.

    //add a random shape to the model
    addRandomShape = new JButton("AddRandomShape");
    addRandomShape.setActionCommand("AddRandomShape");
    addRandomShape.addActionListener(this);
    addKeyListener(this);
    addMouseListener(this);
    setLayout( new BorderLayout() );
    add(scrollPane, BorderLayout.CENTER);
    add(addRandomShape, BorderLayout.PAGE_END);


  }
  @Override
  public void render() {
    setFocusable(true);
    requestFocus();
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

  @Override
  public void refresh() {
    repaint();
  }

  @Override
  public void addListener(ViewFeaturesListener listener) {
    this.listenerList.add( Objects.requireNonNull(listener) );
//    this.addRandomShape.setActionCommand("addRandomShape");
//    this.addRandomShape.addActionListener(Objects.requireNonNull(listener) );
//    this.drawingPanel.addMouseListener( Objects.requireNonNull(mListener));
//    this.addKeyListener( Objects.requireNonNull(keyListener));
  }

  @Override
  public void displayError(String message) {
    JOptionPane.showInputDialog(message);
    System.err.println("This should be an error window.");
  }

  public void drawTriangle(int x, int y, int base, int height, Color color){
    this.drawingPanel.drawShape( new DrawingPanelRectangle(x,y,base, height, color, 2));
  }

  private void broadcastShapeAddedEvent(int x, int y){
    for ( ViewFeaturesListener listener : listenerList ){
      listener.handleAddShape(x, y);
    }
  }

  private void broadcastShapeRemovedEvent(){
    for ( ViewFeaturesListener listener : listenerList ){
      listener.handleRemoveShape();
    }
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if ( e.getActionCommand().equals("AddRandomShape")){
      int x = (new Random().nextInt()) % 100;
      int y = (new Random().nextInt()) % 100;
      broadcastShapeAddedEvent(x, y);
    }
  }

  @Override
  public void keyTyped(KeyEvent e) {
    if ( e.getKeyChar() == 'a'){
      broadcastShapeAddedEvent(30, 100);
    }
    else if ( e.getKeyChar() == 'd' ){
      broadcastShapeRemovedEvent();
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
    int x = (new Random().nextInt()) % 100;
    int y = (new Random().nextInt()) % 100;
    broadcastShapeAddedEvent(x, y);
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
