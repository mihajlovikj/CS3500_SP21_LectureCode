import java.awt.Adjustable;
import java.awt.BorderLayout;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.Objects;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JViewport;
import javax.swing.ViewportLayout;

public class MyScrollPane extends JPanel {
  private final JPanel delegate;
  private final JScrollBar horizontal;
  private final JScrollBar vertical;
  //private final JViewport viewport;
  public MyScrollPane(JPanel delegate){
    super();
    this.delegate = Objects.requireNonNull(delegate);
    setLayout( new BorderLayout());
    add( this.delegate, BorderLayout.CENTER );
    this.horizontal = new JScrollBar(Adjustable.HORIZONTAL);
    this.vertical = new JScrollBar(Adjustable.VERTICAL);
    //this.viewport = new ViewportLayout();
    this.horizontal.addAdjustmentListener(new AdjustmentListener() {
      @Override
      public void adjustmentValueChanged(AdjustmentEvent e) {
        System.out.println(e.getValue());
      }
    });

    add( horizontal, BorderLayout.SOUTH);
    add( vertical, BorderLayout.EAST);
  }
}
