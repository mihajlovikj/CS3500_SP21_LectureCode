package controller;

import TracingModel.ITracingTurtleModel;
import java.util.Objects;
import java.util.Scanner;

public class MoveCommand extends AbstractTurtleCommand implements ICommand {
  private int internalState;
  public MoveCommand(ITracingTurtleModel model, Appendable out){
    super(model, out);
    this.internalState = 0;
  }

  @Override
  public void run(Scanner scanner) {

    double value = getNextDouble(scanner, out,"Invalid move value");
    model.move(value);

    if ( this.internalState % 2 == 0){
      append(out, "Moving " + value);
    }else{
      append(out, "Moving: " + value);
    }

    this.internalState++;

  }
}
