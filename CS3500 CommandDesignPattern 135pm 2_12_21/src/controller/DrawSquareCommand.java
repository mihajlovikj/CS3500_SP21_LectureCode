package controller;

import java.util.Objects;
import java.util.Scanner;
import model.ITracingTurtleGraphics;

public class DrawSquareCommand extends AbstractTurtleCommand{
  public DrawSquareCommand(ITracingTurtleGraphics model, Appendable out) {
    super(model, out);
  }
  @Override
  public void run(Scanner scanner) {
    double size = getNextDouble(scanner);
    this.model.move(size);
    this.model.turn(90);
    this.model.move(size);
    this.model.turn(90);
    this.model.move(size);
    this.model.turn(90);
    this.model.move(size);
  }
}
