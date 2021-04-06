package cs3500.tictactoe.controller.strategies;

import cs3500.tictactoe.model.Piece;
import cs3500.tictactoe.model.TicTacToeModel;
import java.awt.Point;
import java.util.Objects;

public class CombinedStrategy implements IStrategy{
  private final IStrategy first;
  private final IStrategy second;


  public CombinedStrategy(IStrategy first, IStrategy second) {
    this.first = Objects.requireNonNull(first);
    this.second = Objects.requireNonNull(second);
  }


  @Override
  public Point getPosition(TicTacToeModel model, Piece piece) {
    Point position = this.first.getPosition(model, piece);
    if ( position == null ){
      return this.second.getPosition(model,piece);
    }
    return position;
  }
}
