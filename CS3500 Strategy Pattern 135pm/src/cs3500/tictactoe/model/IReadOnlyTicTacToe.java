package cs3500.tictactoe.model;

public interface IReadOnlyTicTacToe {
  int getWidth();
  int getHeight();
  int getGoal();
  Piece getPieceAt(int r, int c);
  Status gameStatus();
  Piece getWinner();
}
