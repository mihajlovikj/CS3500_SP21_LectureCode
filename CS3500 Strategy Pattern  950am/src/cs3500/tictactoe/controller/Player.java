package cs3500.tictactoe.controller;

import cs3500.tictactoe.controller.strategies.IStrategy;
import cs3500.tictactoe.model.Piece;
import cs3500.tictactoe.model.TicTacToeModel;
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
    return this.piece;
  }


  @Override
  public Point play(TicTacToeModel model) {
    return this.strategy.getPosition(model, piece);
  }
}
