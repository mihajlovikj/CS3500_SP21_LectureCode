package cs3500.tictactoe.controller;

import cs3500.tictactoe.model.Piece;
import cs3500.tictactoe.model.TicTacToeModel;
import java.awt.Point;

public interface IPlayer {
  //Might have to add some more methods.
  Piece getPiece();
  Point play(TicTacToeModel model);
}
