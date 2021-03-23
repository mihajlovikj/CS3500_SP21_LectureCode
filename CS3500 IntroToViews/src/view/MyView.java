package view;

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
import java.util.Objects;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import model.IModel;
import model.IViewModel;

public class MyView extends JFrame implements IView{
  private final JButton submit;
  private final JButton refresh;
  private final JLabel usernameLabel;
  private final JLabel infoLabel;
  private final JTextField usernameTextInput;
  private final JButton refresh2FromMenu;
  private final MyDrawingPanel canvas;
  public MyView() throws NullPointerException{
    super();

    setSize(new Dimension(600, 300));
    setLocation( new Point(800,600));
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    setLayout( new FlowLayout() );
    this.canvas = new MyDrawingPanel();
    this.canvas.setPreferredSize( new Dimension(600,600));
    this.canvas.setBackground( Color.yellow );

    this.submit = new JButton("Submit");
    this.refresh = new JButton("Refresh");
    this.usernameLabel = new JLabel("Username: ");
    this.infoLabel = new JLabel("Info");
    this.usernameTextInput = new JTextField(30);
    this.refresh2FromMenu = new JButton("RefreshFromMenu");

    add(usernameLabel);
    add(usernameTextInput);
    add(submit);
    add(refresh);
    add(infoLabel);
    add(canvas);
    pack();
  }

  @Override
  public void render() {
    setVisible(true);
  }

  @Override
  public void addListners(ActionListener listener, KeyListener keyListener) {
    this.submit.addActionListener( Objects.requireNonNull(listener));
    this.submit.setActionCommand("submitt");
    this.refresh.addActionListener(Objects.requireNonNull(listener));
    this.refresh.setActionCommand("refresh");
    this.refresh2FromMenu.addActionListener( Objects.requireNonNull(listener));
    this.refresh2FromMenu.setActionCommand("submitt");

    this.usernameTextInput.addKeyListener( Objects.requireNonNull(keyListener));
  }

  @Override
  public String getText() {
    return this.usernameTextInput.getText();
  }

  @Override
  public void setMessage(String message) throws NullPointerException {
    this.infoLabel.setText( Objects.requireNonNull(message) );
  }

//  public void drawRect(int ... values){
//    canvas.drawRect(values[0] ....);
//  }
}
