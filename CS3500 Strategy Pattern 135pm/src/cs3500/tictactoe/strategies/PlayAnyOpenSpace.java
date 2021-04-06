package cs3500.tictactoe.strategies;

import cs3500.tictactoe.model.Piece;
import cs3500.tictactoe.model.TicTacToeModel;
import java.awt.Point;

/*
    interface ICommand{
      void run();
    }

    interface Motion{
      void apply(int tick);
    }

    interface Predicate<T>{
      boolean apply(T value);
    }

    interface BiFunction<T,T,U>{
      U apply(T a, T b);
    }

    interface IStrategy{
      Point getPosition(TicTacToe model, Piece piece);
    }
 */

public class PlayAnyOpenSpace implements IStrategy{

  @Override
  public Point getPosition(TicTacToeModel model, Piece piece) {
    for ( int i = 0; i < model.getHeight(); i++ ){
      for ( int j = 0; j < model.getWidth(); j++){
        if ( model.getPieceAt(i,j) == Piece.EMPTY){
          return new Point(i,j);
        }
      }
    }
    return null;
  }
}
