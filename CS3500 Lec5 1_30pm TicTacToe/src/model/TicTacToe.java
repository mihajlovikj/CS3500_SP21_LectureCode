package model;

import java.lang.reflect.Array;
import java.nio.channels.FileLockInterruptionException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicTacToe implements ITicTacToe{
  private final IPlayer [][] gameGrid;
  private  IPlayer nextPlayer;
  private final List<IPlayer> players;
  private boolean gameStarted;
  //Default constructor
  public TicTacToe(){

    this.gameGrid = new IPlayer[3][3];
    this.players = new ArrayList<>();
    this.players.add(new Player("X"));
    this.players.add(new Player("O"));
    //TODO: initalizze game grid.
  }

  public TicTacToe(String ... playerCodes){
    this.gameGrid = new IPlayer[3][3];

    if ( playerCodes == null ){
      throw new IllegalArgumentException("players cannot be null");
    }

    //Did not make a copy of each player because IPlayer is non mutable.
    this.players = new ArrayList<>();

    //TODO: figure out why this is not optinal.
    for ( String playerCode : playerCodes){
        this.players.add(  new Player(playerCode) );
      }
  }

  //We want the user to create the players.
  //We want them to pick what player codes they want.

  @Override
  public void move(int x, int y) {
    this.gameStarted = true;
    //Do the move and error checking etc.
    //TODO: update the player.
  }

  @Override
  public IPlayer nextPlayer() {
    //TODO: fix.
    return null;
  }

  @Override
  public boolean isGameOver() {
    return false;
  }

  @Override
  public IPlayer getWinner() {
    return null;
  }

  @Override
  public IPlayer getPlayerAt(int row, int col) {
    return null;
  }

  @Override
  public String toString() {
    String result = "";
    for ( IPlayer player : players){
      result += player.toString() + " ";
    }

    return result;
  }
}
