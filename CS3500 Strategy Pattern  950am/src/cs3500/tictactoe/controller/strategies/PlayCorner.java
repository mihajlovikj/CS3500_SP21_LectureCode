package cs3500.tictactoe.controller.strategies;

import cs3500.tictactoe.model.Piece;
import cs3500.tictactoe.model.TicTacToeModel;
import java.awt.Point;

public class PlayCorner implements IStrategy{

  @Override
  public Point getPosition(TicTacToeModel model, Piece piece) {
    //an empty corner.
    if ( model.getPieceAt(0,0) == Piece.EMPTY ){ //top left.
      return new Point(0,0);
    }else if ( model.getPieceAt(0,model.getWidth()) == Piece.EMPTY ) { //top right.
      return new Point(0, model.getWidth());
    }else if ( model.getPieceAt(model.getHeight(),0) == Piece.EMPTY ) { //bottom right.
      return new Point(model.getHeight(), 0);
    }else if ( model.getPieceAt(model.getHeight(),model.getWidth()) == Piece.EMPTY ) { //bottom right.
      return new Point(model.getHeight(), model.getWidth());
    }
    return null;
  }
}
