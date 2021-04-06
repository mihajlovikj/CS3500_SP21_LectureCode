package cs3500.tictactoe.controller.strategies;

import cs3500.tictactoe.model.Piece;
import cs3500.tictactoe.model.TicTacToeModel;
import java.awt.Point;

public class TryToBlock implements IStrategy{

  @Override
  public Point getPosition(TicTacToeModel model, Piece piece) {
    for ( int i = 0; i < model.getWidth(); i++) {
      for (int j = 0; j < model.getHeight(); j++) {
        //figure out if the opposite player is about to win and block the line.
      }
    }
    return null;
  }
}
