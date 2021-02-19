package controller;

import TracingModel.ITracingTurtleModel;
import java.util.Objects;
import java.util.Scanner;

public class RetrieveCommand extends AbstractTurtleCommand {
  public RetrieveCommand(ITracingTurtleModel model, Appendable out){
    super(model, out);
  }

  @Override
  public void run(Scanner scanner) {
    model.retrieve();
    append(out, "Retrieving ");
  }
}
