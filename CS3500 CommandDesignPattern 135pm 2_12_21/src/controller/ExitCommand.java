package controller;

import java.util.Scanner;
import model.ITracingTurtleGraphics;

public class ExitCommand extends AbstractTurtleCommand{

  public ExitCommand(ITracingTurtleGraphics model, Appendable out) {
    super(model, out);
  }

  @Override
  public void run(Scanner scanner) {

  }
}
