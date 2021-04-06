package cs3500.tictactoe.model;

/**
 * Description of the pieces on a TicTacToe board
 */
public enum Piece {
  X, O, EMPTY;

  @Override
  public String toString() {
    if (this == X) return "X";
    else if (this == O) return "O";
    else return " ";
  }
}
