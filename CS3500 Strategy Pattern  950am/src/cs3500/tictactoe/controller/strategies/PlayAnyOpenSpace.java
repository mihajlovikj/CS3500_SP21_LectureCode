package cs3500.tictactoe.controller.strategies;

import cs3500.tictactoe.model.Piece;
import cs3500.tictactoe.model.TicTacToeModel;
import java.awt.Point;

public class PlayAnyOpenSpace implements IStrategy{

  @Override
  public Point getPosition(TicTacToeModel model, Piece piece) {
    //Play in the first open spot - easy
    for ( int i = 0; i < model.getWidth(); i++){
      for ( int j = 0; j < model.getHeight(); j++){
        if ( model.getPieceAt(i, j) == Piece.EMPTY ){
          return new Point(i,j);
        }
      }
    }
    return null;
  }
}
