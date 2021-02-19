package controller;

import TracingModel.ITracingTurtleModel;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

public class NewController extends Controller{

  public NewController(ITracingTurtleModel model, Readable in, Appendable out) {
    super(model, in, out);
  }

  @Override
  protected Map<String, Supplier<ICommand>> getKnownCommands() {
//    Map<String, ICommand> knownCommands = super.getKnownCommands();
//    knownCommands.putIfAbsent("square", new SquareCommand(model, out) );
//    return knownCommands;
    return null;
  }
}
