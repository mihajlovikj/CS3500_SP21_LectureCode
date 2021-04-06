package cs3500.tictactoe.model;

/**
 * Represents a TicTacToe board
 */
public interface TicTacToeModel {
  int getWidth();
  int getHeight();
  int getGoal();
  Piece getPieceAt(int r, int c);
  void setPieceAt(int r, int c, Piece p);
  Status gameStatus();
  Piece getWinner();
}
