package controller;

import java.util.Objects;
import java.util.Scanner;
import model.ITracingTurtleGraphics;

public class TurnCommand extends AbstractTurtleCommand {
   public TurnCommand(ITracingTurtleGraphics model, Appendable out) {
    super(model, out);
  }
  @Override
  public void run(Scanner scanner) {
    double angle = getNextDouble(scanner);
    this.model.turn(angle);
    append(scanner, "Moving " + angle);
  }
}
