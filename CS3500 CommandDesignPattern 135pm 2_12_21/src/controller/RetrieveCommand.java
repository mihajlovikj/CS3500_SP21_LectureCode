package controller;

import java.util.Objects;
import java.util.Scanner;
import model.ITracingTurtleGraphics;

public class RetrieveCommand extends AbstractTurtleCommand{
  public RetrieveCommand(ITracingTurtleGraphics model, Appendable out) {
    super(model,out);
  }
  @Override
  public void run(Scanner scanner) {
    append(scanner, "Retrieving");
    this.model.retrieve();
  }
}
