package cs3500.tictactoe.strategies;

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
    int x = -1;
    int y = -1;
    if ( scanner.hasNextInt())
      x = scanner.nextInt();

    if ( scanner.hasNextInt() )
      y = scanner.nextInt();

    if ( x == -1 || y == -1 ){
      return null;
    }

    return new Point(x,y);
  }
}
