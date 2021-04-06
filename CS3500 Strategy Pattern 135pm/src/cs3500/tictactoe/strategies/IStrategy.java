package cs3500.tictactoe.strategies;

import cs3500.tictactoe.model.IReadOnlyTicTacToe;
import cs3500.tictactoe.model.Piece;
import cs3500.tictactoe.model.TicTacToeModel;
import java.awt.Point;

public interface IStrategy {
  Point getPosition(IReadOnlyTicTacToe model, Piece piece);
}
