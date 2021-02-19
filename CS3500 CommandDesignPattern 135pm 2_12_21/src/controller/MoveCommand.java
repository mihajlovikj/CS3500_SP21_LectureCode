package controller;

import java.util.Objects;
import java.util.Scanner;
import model.ITracingTurtleGraphics;

public class MoveCommand extends AbstractTurtleCommand{
  private int internalStateVariable;
  //every time we get a new command I want a brand new command
  public MoveCommand(ITracingTurtleGraphics model, Appendable out) {
    super(model, out);
    this.internalStateVariable = 10;
  }


  @Override
  public void run(Scanner scanner) {
    double distance = getNextDouble(scanner);
    this.model.move(distance);
    append(scanner, "Moving " + distance);
    this.internalStateVariable++;
  }
}
