package controller;

import TracingModel.ITracingTurtleModel;
import com.sun.jdi.VoidType;
import java.io.IOException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Supplier;

public class Controller implements IController{
  protected final ITracingTurtleModel model;
  protected final Readable in;
  protected final Appendable out;
  public Controller(ITracingTurtleModel model, Readable in, Appendable out){
    if ( model == null ){
      throw new IllegalArgumentException("Model cannot be null.");
    }
    this.model = model;
    this.in = Objects.requireNonNull(in);
    this.out = Objects.requireNonNull(out);
  }

  private void triangleCommand(Scanner scanner){
    //TODO.
  }

  protected Map<String,Supplier<ICommand> > getKnownCommands(){
    Map<String, Supplier<ICommand>> knownCommands = new HashMap<String, Supplier<ICommand>>();

    knownCommands.putIfAbsent("move", () -> { return new MoveCommand(model, out); } );//TODO: Potential bug? Always the same instance
    knownCommands.putIfAbsent("turn", () -> { return new TurnCommand(model, out); } );
    knownCommands.putIfAbsent("save", () ->   { return new SaveCommand(model, out); });
    knownCommands.putIfAbsent("retrieve", () -> { return new RetrieveCommand(model, out); });

    knownCommands.putIfAbsent("square", () -> { return new AbstractTurtleCommand(model, out) {
      @Override
      public void run(Scanner scanner) {
        double size = getNextDouble(scanner, out, "Invalid size.");
        model.move(size);
        model.turn(90);
        model.move(size);
        model.turn(90);
        model.move(size);
        model.turn(90);
        model.move(size);
      }
    };});
    return knownCommands;
  }
  @Override
  public void go() throws IllegalStateException{
    Map<String, Supplier<ICommand> > knownCommands = getKnownCommands();
    Scanner scanner = new Scanner(this.in); //Readable.
    ICommand command = null;
    while (scanner.hasNext() ){

      String input = scanner.next(); //move, turn, save, retrieve
      if ( input.equalsIgnoreCase("q")) return;
     Supplier<ICommand> functionCommand = knownCommands.getOrDefault(input, null); //move
    //0x100;
      if ( functionCommand != null ){
        command = functionCommand.get(); //running the function.
        command.run(scanner);
        //(0x100).run(scanner);
      }
    }
  }
}
