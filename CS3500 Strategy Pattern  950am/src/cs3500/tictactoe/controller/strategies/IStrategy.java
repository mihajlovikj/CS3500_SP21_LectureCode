package cs3500.tictactoe.controller.strategies;

import cs3500.tictactoe.model.Piece;
import cs3500.tictactoe.model.ReadonlyTicTacToeModel;
import cs3500.tictactoe.model.TicTacToeModel;
import java.awt.Point;

/* public interface ICommand{
  public void run();
 */
/*
  public interface IMotion{
    public void apply(int tick);
  }
 */
public interface IStrategy {
  Point getPosition(ReadonlyTicTacToeModel model, Piece piece);
}
