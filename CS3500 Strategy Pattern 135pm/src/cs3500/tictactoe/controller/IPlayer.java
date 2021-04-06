package cs3500.tictactoe.controller;

import cs3500.tictactoe.model.IReadOnlyTicTacToe;
import cs3500.tictactoe.model.Piece;
import cs3500.tictactoe.model.ReadonlyTicTacToeModel;
import cs3500.tictactoe.model.TicTacToeModel;
import java.awt.Point;

public interface IPlayer {
  Piece getPiece();
  Point getPosition(IReadOnlyTicTacToe model);
}
