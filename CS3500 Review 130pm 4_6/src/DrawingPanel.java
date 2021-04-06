import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JPanel;

public class DrawingPanel extends JPanel {
  private final JButton button;
  public DrawingPanel(){
    super();
    setBackground(Color.yellow);
    setPreferredSize( new Dimension(800,800));
    setLayout( new BorderLayout());
    button = new JButton("Start");
    add(button, BorderLayout.SOUTH);
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    g.setColor(Color.black);
    g.fillOval(300,300,300,300);
  }
}
