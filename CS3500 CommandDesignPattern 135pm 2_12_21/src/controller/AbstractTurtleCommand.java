package controller;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;
import model.ITracingTurtleGraphics;

public abstract class AbstractTurtleCommand implements ICommand {
  protected  final ITracingTurtleGraphics model;
  protected final Appendable out;
  public AbstractTurtleCommand(ITracingTurtleGraphics model, Appendable out) {
    this.model = Objects.requireNonNull(model);
    this.out = Objects.requireNonNull(out);
  }

  protected void append(Scanner scanner, String value){
    Objects.requireNonNull(scanner);
    Objects.requireNonNull(value);
    try {
      out.append("Command: ");
      out.append(value);
      out.append("\n");
    }catch(IOException e){
      throw new IllegalStateException("Couldn't write to appendable.");
    }
  }

  protected double getNextDouble(Scanner scanner){
    while ( true ) {
      try {
        double value = scanner.nextDouble();
        return value;
      } catch (InputMismatchException e) {
        String token = scanner.next();//consume the invalid input.
        append(scanner, "Invalid input: " + token);
      }
    }
  }

  @Override
  public abstract void run(Scanner scanner);
}
