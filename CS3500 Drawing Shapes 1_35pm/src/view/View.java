package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class View extends JFrame implements IView, ActionListener, KeyListener, MouseListener {
  private final DrawingPanel drawingPanel;
  private final JButton startAnimation;
  private final JButton addRandomShape;
  private final List<ViewListner> listnerList;
  //            key = charCode
  private final Map<Character, Runnable> keyMap;
  public View(int x, int y){
    super();

    setSize(new Dimension(x, y));
    setLocation( new Point(600,600));
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    keyMap = new HashMap<>();
    initKeys();

    listnerList = new ArrayList<>();
    drawingPanel = new DrawingPanel();
    startAnimation = new JButton("Start");
    addRandomShape = new JButton("Add Random Shape");
    addRandomShape.setActionCommand("addRandomShape");

    addRandomShape.addActionListener(Objects.requireNonNull(this));
    this.addKeyListener( Objects.requireNonNull(this));
    this.drawingPanel.addMouseListener(this);

    setLayout( new BorderLayout());
    add(drawingPanel, BorderLayout.CENTER);
    add(addRandomShape, BorderLayout.PAGE_END);
  }


  @Override
  public void render() {
    setFocusable(true);
    requestFocus();
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

  @Override
  public void addListener(ViewListner listner) {
      listnerList.add( Objects.requireNonNull(listner) );
  }

  @Override
  public void resetFocus() {
    setFocusable(true);
    requestFocus();
  }

  @Override
  public void displayError(String message) {
    JOptionPane.showInputDialog(message);
  }

  private void emitShapeAddedEvent(int x, int y){
    for ( ViewListner  viewListner : listnerList ){
      viewListner.shapeAddedEvent(x, y);
    }
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if ( e.getActionCommand().equals("addRandomShape")){
      int randX = (new Random()).nextInt() % 200;
      int randY = (new Random()).nextInt() % 200;
      emitShapeAddedEvent(randX, randY);
    }
  }

  void initKeys(){
//    try {
//      Scanner scanner = new Scanner(file);
//
//    } catch (FileNotFoundException e) {
//      e.printStackTrace();
//    }


    keyMap.putIfAbsent('a', new Runnable() {
      @Override
      public void run() {
        int randX = (new Random()).nextInt() % 200;
        int randY = (new Random()).nextInt() % 200;
        emitShapeAddedEvent(randX, randY);
      }
    });

    keyMap.putIfAbsent(' ', new Runnable() {
      @Override
      public void run() {
        for ( ViewListner listner : listnerList ){
          listner.shapeRemovedEvent();
        }
      }
    });
  }
  @Override
  public void keyTyped(KeyEvent e) {
    Runnable runnable = keyMap.getOrDefault(e.getKeyChar(), null);
    if ( runnable != null ){
      runnable.run();
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
    int randX = (new Random()).nextInt() % 200;
    int randY = (new Random()).nextInt() % 200;
    //Should the view update itself. No.
    //drawRectangle(  randX, randY, 50, 50, Color.red);
    emitShapeAddedEvent(randX, randY);
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
