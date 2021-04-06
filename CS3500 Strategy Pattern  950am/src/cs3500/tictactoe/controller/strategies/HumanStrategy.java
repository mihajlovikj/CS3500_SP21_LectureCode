package cs3500.tictactoe.controller.strategies;

import cs3500.tictactoe.model.Piece;
import cs3500.tictactoe.model.TicTacToeModel;
import java.awt.Point;
import java.util.Objects;
import java.util.Scanner;

public class HumanStrategy implements IStrategy{
  private final Readable in;

  public HumanStrategy(Readable in) {
    this.in = Objects.requireNonNull(in);
  }

  @Override
  public Point getPosition(TicTacToeModel model, Piece piece) {
    Scanner scanner = new Scanner(in);
    int x = scanner.nextInt();
    int y = scanner.nextInt();
    return new Point(x,y);
  }
}
