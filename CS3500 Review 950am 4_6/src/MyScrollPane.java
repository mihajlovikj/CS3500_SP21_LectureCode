import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JScrollBar;

public class MyScrollPane extends JPanel {
  JPanel border = new JPanel();
  public MyScrollPane(JPanel delegate){
    super();

    setLayout( new BorderLayout());
    add( delegate, BorderLayout.CENTER);
    add( new JScrollBar(JScrollBar.HORIZONTAL), BorderLayout.PAGE_END);
    border.setBackground(Color.black);
    border.setPreferredSize(new Dimension(10, this.getHeight()));
    add( border, BorderLayout.WEST);
  }


}
