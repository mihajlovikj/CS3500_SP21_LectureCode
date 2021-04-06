import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawingPanel extends JPanel {
  public DrawingPanel(){
    super();
    setBackground(Color.yellow);
    setPreferredSize(new Dimension(3000,3000));
    setLayout( new BorderLayout());
    add( BorderLayout.PAGE_END, new JButton("ClickMe"));

  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    g.setColor(Color.green);
    g.fillOval(300,300,300,300);
  }
}
