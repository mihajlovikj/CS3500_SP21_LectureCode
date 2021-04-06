import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class View extends JFrame implements ModelAddUserHandler {
  DrawingPanel drawingPanel;
  JPanel container;
  public View(){
    super();
    setSize(new Dimension(800,800));
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    drawingPanel = new DrawingPanel();
//    IList list = new ConsLoPanels( new MyScrollPane(), new ConsLoPanels)
    container = new MyScrollPane( new BorderPane(drawingPanel) ); // example of decorator pattern.
    add(container);
    setVisible(true);
  }

  @Override
  public void handleAddUser(String user) {
    JOptionPane.showMessageDialog( new JFrame("New User"), user);
  }
}
