package cs3500.tictactoe.strategies;

import cs3500.tictactoe.model.IReadOnlyTicTacToe;
import cs3500.tictactoe.model.Piece;
import cs3500.tictactoe.model.ReadonlyTicTacToeModel;
import cs3500.tictactoe.model.TicTacToeModel;
import java.awt.Point;

public class CompositeStrategy implements IStrategy{
  private final IStrategy first;
  private final IStrategy second;

  public CompositeStrategy(IStrategy first, IStrategy second) {
    this.first = first;
    this.second = second;
  }

  @Override
  public Point getPosition(IReadOnlyTicTacToe model, Piece piece) {
    Point pos = this.first.getPosition(model, piece);
    if ( pos == null ){
      pos = this.second.getPosition(model, piece);
    }

    return pos;
  }
}
