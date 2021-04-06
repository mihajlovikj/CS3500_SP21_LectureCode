package cs3500.tictactoe.strategies;

import cs3500.tictactoe.model.Piece;
import cs3500.tictactoe.model.TicTacToeModel;
import java.awt.Point;

public class PlayACorner implements IStrategy{

  @Override
  public Point getPosition(TicTacToeModel model, Piece piece) {
    if ( model.getPieceAt(0, model.getHeight() - 1 ) == Piece.EMPTY) { // top right corner
      return new Point(0, model.getHeight() - 1);
    }else if ( model.getPieceAt(0, 0) == Piece.EMPTY) { // top left corner
      return new Point(0, 0);
    }else  if ( model.getPieceAt(model.getWidth(), 0) == Piece.EMPTY) { // bottom left corner
      return new Point(model.getWidth(), 0);
    }else if ( model.getPieceAt(model.getWidth(), model.getHeight()) == Piece.EMPTY) { // bottom right corner
      return new Point(model.getWidth(), model.getHeight());
    }

    return null;
  }
}
