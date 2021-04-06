import java.awt.Dimension;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class View extends JFrame implements IModelEventHandler {
  private final DrawingPanel drawingPanel;
  private final MyScrollPane myScrollPane;
  public View(){
    super();
    setSize( new Dimension(1000,1000));
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    drawingPanel = new DrawingPanel();
    //tea      = new Tea(          almondMilk  );
    myScrollPane = new MyScrollPane( drawingPanel );
    add( myScrollPane );
  }

  @Override
  public void handleUserAdded(String user) {
    JOptionPane.showMessageDialog(new JFrame("Event"), user);
  }
}
