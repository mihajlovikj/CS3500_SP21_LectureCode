package controller;

import TracingModel.ITracingTurtleModel;
import java.util.Objects;
import java.util.Scanner;

public class SaveCommand extends AbstractTurtleCommand {
  public SaveCommand(ITracingTurtleModel model, Appendable out){
    super(model, out);
  }

  @Override
  public void run(Scanner scanner) {
    model.save();
    append(out, "Saving ");
  }
}
