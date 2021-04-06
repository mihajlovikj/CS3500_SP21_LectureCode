package cs3500.tictactoe.controller;

import cs3500.tictactoe.model.IReadOnlyTicTacToe;
import cs3500.tictactoe.model.Piece;
import cs3500.tictactoe.model.ReadonlyTicTacToeModel;
import cs3500.tictactoe.model.TicTacToeModel;
import cs3500.tictactoe.strategies.IStrategy;
import java.awt.Point;
import java.util.Objects;

public class Player implements IPlayer{
  private final Piece piece;
  private final IStrategy strategy;
  public Player(Piece piece, IStrategy strategy) {
    this.piece = Objects.requireNonNull(piece);
    this.strategy = Objects.requireNonNull(strategy);
  }

  @Override
  public Piece getPiece() {
    return piece;
  }

  @Override               //this is an adapter.
  public Point getPosition(IReadOnlyTicTacToe model) {
    //this compiles.
    //HA HA!!!!
    if ( strategy == null ){
      return null;
    }
    return strategy.getPosition(model, piece);
//  }
  }
}
