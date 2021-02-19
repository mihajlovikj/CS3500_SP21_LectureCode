package controller;

import TracingModel.ITracingTurtleModel;
import java.util.Scanner;

public class SquareCommand extends AbstractTurtleCommand {

  protected SquareCommand(ITracingTurtleModel model, Appendable out) {
    super(model, out);
  }

  @Override
  public void run(Scanner scanner) {
    double size = getNextDouble(scanner, out, "Size is not valid.");
    model.move(size);
    model.turn(90);
    model.move(size);
    model.turn(90);
    model.move(size);
    model.turn(90);
    model.move(size);
  }
}
