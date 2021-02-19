package controller;

import java.util.Objects;
import java.util.Scanner;
import model.ITracingTurtleGraphics;

public class SaveCommand extends AbstractTurtleCommand {
  public SaveCommand(ITracingTurtleGraphics model, Appendable out) {
    super(model, out);
  }
  @Override
  public void run(Scanner scanner) {
    append(scanner, "Saving");
    this.model.save();
  }
}
