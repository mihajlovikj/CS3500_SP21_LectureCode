package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.function.Function;
import model.ITracingTurtleGraphics;

public class Controller implements IController{
  private final ITracingTurtleGraphics model;
  private final Appendable out;
  private final Readable in;
  public Controller(ITracingTurtleGraphics model, Appendable out, Readable in) {
    this.model = Objects.requireNonNull(model);
    this.out = Objects.requireNonNull(out);
    this.in = Objects.requireNonNull(in);
  }





  @Override
  public void go() {
    Scanner scanner = new Scanner(this.in);
    Map<String, Function<Scanner, ICommand>> knownCommands = ModelUtil.getKnownCommands(this.model, this.out);

    Function<Scanner, ICommand> functionCommand = null;
    while ( scanner.hasNext() ){
      String input = scanner.next();
      if ( input.equalsIgnoreCase("q") ){
        return;//TODO: print the game state and quit.
      }
      functionCommand = knownCommands.getOrDefault(input, null);
      //0x100;
      if ( functionCommand != null ){
        ICommand command = functionCommand.apply(scanner);
        command.run(scanner); //0x100.run(scanner);
      }

    }
  }
}
