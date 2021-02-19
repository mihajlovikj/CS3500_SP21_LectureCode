package controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import model.ITracingTurtleGraphics;

public class ModelUtil {
  public static Map<String, Function<Scanner, ICommand>> getKnownCommands(ITracingTurtleGraphics model, Appendable out){
    Map<String, Function<Scanner, ICommand>> knownCommands = new HashMap<String, Function<Scanner, ICommand>>();
    ICommand move = new MoveCommand(model, out); //0x100
    knownCommands.putIfAbsent("move", scanner -> { return new MoveCommand(model, out); });//=0x100
    knownCommands.putIfAbsent("turn", scanner -> { return new TurnCommand(model, out); });
    knownCommands.putIfAbsent("save", scanner -> { return new SaveCommand(model, out); });
    knownCommands.putIfAbsent("retrieve", scanner -> { return new RetrieveCommand(model, out); });
    knownCommands.putIfAbsent("square", scanner -> { return new DrawSquareCommand(model, out); });
    knownCommands.putIfAbsent("triangle", scanner -> { return new TriangleCommand(model, out); });

    return knownCommands;
  }
}
