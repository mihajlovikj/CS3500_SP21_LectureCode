package cs3500.tictactoe.strategies;

import cs3500.tictactoe.model.Piece;
import cs3500.tictactoe.model.TicTacToeModel;
import java.awt.Point;

public class PlayCenter implements IStrategy{

  @Override
  public Point getPosition(TicTacToeModel model, Piece piece) {
    if ( model.getPieceAt( model.getWidth()/ 2, model.getHeight()/2 ) == Piece.EMPTY){
      return new Point (model.getWidth()/ 2, model.getHeight()/2);
    }
    return null;
  }
}
