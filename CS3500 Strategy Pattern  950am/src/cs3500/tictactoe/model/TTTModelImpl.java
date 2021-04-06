package cs3500.tictactoe.model;

/**
 * Implementation of a TicTacToe game, generalized to arbitrary sizes
 */
public class TTTModelImpl implements TicTacToeModel {
  public static class Builder {
    int w;
    int h;
    int g;
    public Builder setWidth(int w) { this.w = w; return this; }
    public Builder setHeight(int h) { this.h = h; return this; }
    public Builder setGoal(int g) { this.g = g; return this; }
    public TTTModelImpl build() {
      return new TTTModelImpl(this.w, this.h, this.g);
    }
  }

  private final int width;
  private final int height;
  private final int goal;
  private final Piece[][] board;
  private TTTModelImpl(int width, int height, int goal) {
    if (goal > height && goal > width)
      throw new IllegalArgumentException("Unwinnable game");

    this.width = width;
    this.height = height;
    this.goal = goal;
    this.gameState = Status.Playing;
    this.winner = null;
    this.board = new Piece[this.height][this.width];


    for (int r = 0; r < height; r++)
      for (int c = 0; c < width; c++)
        this.board[r][c] = Piece.EMPTY;
  }
  @Override
  public int getWidth() {
    return this.width;
  }

  @Override
  public int getHeight() {
    return this.height;
  }

  @Override
  public int getGoal() {
    return this.goal;
  }

  @Override
  public Piece getPieceAt(int r, int c) {
    if (r < 0 || r >= this.height) throw new IllegalArgumentException("Bad row: " + r);
    if (c < 0 || c >= this.width) throw new IllegalArgumentException("Bad col: " + c);
    return this.board[r][c];
  }

  @Override
  public void setPieceAt(int r, int c, Piece p) {
    if (r < 0 || r >= this.height) throw new IllegalArgumentException("Bad row: " + r);
    if (c < 0 || c >= this.width) throw new IllegalArgumentException("Bad col: " + c);
    if (p == null) throw new IllegalArgumentException("Null piece");

    if (this.board[r][c] != Piece.EMPTY) throw new IllegalStateException("Board space isn't empty");

    this.board[r][c] = p;
    this.moveCount += 1;
    this.updateWinner();
  }

  private Status gameState;
  private Piece winner;
  private int moveCount = 0;

  /**
   * Checks for a winning configuration on the line starting at (r,c) and continuing
   * in the direction (dr, dc)
   * @param r The row to start from
   * @param c The column to start from
   * @param dr The delta in rows
   * @param dc The delta in cols
   */
  private void checkWin(int r, int c, int dr, int dc) {
    Piece cur = null;
    int count = 0;
    while (r >= 0 && r < this.height && c >= 0 && c < this.width) {
      if (this.board[r][c] == cur) {
        count++;
      } else {
        count = 1;
        cur = this.board[r][c];
      }
      if (cur != null && cur != Piece.EMPTY && count == this.goal) {
        this.gameState = Status.Won;
        this.winner = cur;
        return;
      }
      r += dr;
      c += dc;
    }
  }
  private void updateWinner() {
    // check for win in rows
    for (int r = 0; r < this.height; r++) {
      checkWin(r, 0, 0, 1);
    }
    // check for win in cols
    for (int c = 0; c < this.width; c++) {
      checkWin(0, c, 1, 0);
    }
    // check for win on diagonals
    for (int r = 0; r < this.height; r++) {
      checkWin(r, 0, -1, 1); // to upper-right, from left column
      checkWin(r, 0, 1, 1); // to lower-right, from left column
    }
    for (int c = 0; c < this.width; c++) {
      checkWin(this.height - 1, c, -1, 1); // to upper-right, from bottom row
      checkWin(0, c, 1, 1); // to lower-right, from top row
    }
    if (this.gameState == Status.Playing && this.moveCount == this.getWidth() * this.getHeight())
      this.gameState = Status.Tied;
  }
  @Override
  public Status gameStatus() { return this.gameState; }

  @Override
  public Piece getWinner() {
    if (this.gameState == Status.Playing) throw new IllegalStateException("Game isn't over");
    return this.winner;
  }
}
