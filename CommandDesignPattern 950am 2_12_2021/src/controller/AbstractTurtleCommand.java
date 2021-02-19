package controller;

import TracingModel.ITracingTurtleModel;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Scanner;

public abstract class AbstractTurtleCommand implements ICommand{
  protected final ITracingTurtleModel model;
  protected final Appendable out;

  protected AbstractTurtleCommand(ITracingTurtleModel model, Appendable out) {
    this.model = Objects.requireNonNull(model);
    this.out = Objects.requireNonNull(out);
  }

  protected double getNextDouble(Scanner scanner, Appendable out, String message) {
    while (true) {
      try {
        double value = scanner.nextDouble();
        return value;
      } catch (InputMismatchException e) {
        //Consumed the invalid token.
        String invalidInput = scanner.next();
        append(out, invalidInput + " " + message);
      } catch( NoSuchElementException e){
        throw new IllegalStateException("Nothing to read.");
      }
    }
  }
  protected void append(Appendable out, String value) throws IllegalStateException{
    try {
      out.append("Printing: ");
      out.append(value);
      out.append("\n");
    }catch(IOException e){
      throw new IllegalStateException("Could not write to appendable.");
    }
  }
  @Override
  public abstract void run(Scanner scanner);
}
