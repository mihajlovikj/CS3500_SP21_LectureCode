package model;

public interface ITicTacToe {
    void move(int x, int y);
    //Not the best representation. TODO: fix later.
    IPlayer nextPlayer();
    boolean isGameOver();
    IPlayer getWinner();
    IPlayer getPlayerAt(int row, int col);
    //Avoid making the copy, we are going with the observer getPlayerAt.
    //int [][] getGrid();
}
