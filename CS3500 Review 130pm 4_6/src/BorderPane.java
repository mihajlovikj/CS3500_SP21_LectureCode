import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Objects;
import javax.swing.JPanel;

public class BorderPane extends JPanel {
  private final JPanel delegate;
  private final JPanel borderHorizontal;
  private final JPanel borderVertical;
  public BorderPane(JPanel delegate){
    super();
    this.delegate = Objects.requireNonNull(delegate);
    setLayout( new BorderLayout() );
    add( this.delegate, BorderLayout.CENTER);
    this.borderHorizontal = new JPanel();
    this.borderHorizontal.setBackground(Color.black);
    this.borderHorizontal.setSize( this.getWidth(), 10);

    this.borderVertical = new JPanel();
    this.borderVertical.setBackground(Color.black);
    this.borderVertical.setSize( 10, this.getHeight() );

    add(borderHorizontal, BorderLayout.NORTH);
    add(borderHorizontal, BorderLayout.SOUTH);
    add(borderVertical, BorderLayout.EAST);
    add(borderVertical, BorderLayout.WEST);
  }
}
