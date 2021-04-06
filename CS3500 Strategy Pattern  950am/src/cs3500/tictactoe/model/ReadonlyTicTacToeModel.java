package cs3500.tictactoe.model;

import java.util.Objects;

/**
 * An adapter from {@link TicTacToeModel} to itself, that prevents
 * access to {@link TicTacToeModel#setPieceAt}.
 */
public class ReadonlyTicTacToeModel implements TicTacToeModel {
  private final TicTacToeModel adaptee;

  public ReadonlyTicTacToeModel(TicTacToeModel adaptee) {
    this.adaptee = Objects.requireNonNull(adaptee);
  }
  @Override
  public int getWidth() {
    return this.adaptee.getWidth();
  }

  @Override
  public int getHeight() {
    return this.adaptee.getHeight();
  }

  @Override
  public int getGoal() {
    return this.adaptee.getGoal();
  }

  @Override
  public Piece getPieceAt(int r, int c) {
    return this.adaptee.getPieceAt(r, c);
  }

  @Override
  public void setPieceAt(int r, int c, Piece p) {
    throw new RuntimeException("How dare you?");
  }

  @Override
  public Status gameStatus() {
    return this.adaptee.gameStatus();
  }

  @Override
  public Piece getWinner() {
    return this.adaptee.getWinner();
  }
}
