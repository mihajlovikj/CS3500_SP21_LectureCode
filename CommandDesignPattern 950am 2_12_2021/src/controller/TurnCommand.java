package controller;

import TracingModel.ITracingTurtleModel;
import java.util.Objects;
import java.util.Scanner;

public class TurnCommand extends AbstractTurtleCommand{
  public TurnCommand(ITracingTurtleModel model, Appendable out){
    super(model, out);
  }

  @Override
  public void run(Scanner scanner) {
    double value = getNextDouble(scanner, out,"Invalid move value");
    model.turn(value);
    append(out, "Moving " + value);
  }
}
