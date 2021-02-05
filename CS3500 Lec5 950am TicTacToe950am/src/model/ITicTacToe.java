package model;

public interface ITicTacToe {
    IPlayer nextPlayer();
    void move(int row, int col);
}
