package cs3500.tictactoe.controller;

import cs3500.tictactoe.controller.strategies.PlayAnyOpenSpace;
import cs3500.tictactoe.controller.strategies.PlayCorner;
import cs3500.tictactoe.model.Piece;
import cs3500.tictactoe.model.Status;
import cs3500.tictactoe.model.TicTacToeModel;
import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Controller implements IController{
  private final TicTacToeModel model;
  private final Appendable out;//view
  private final List<IPlayer> playerList;
  private int playerIndex;
  public Controller(TicTacToeModel model, Appendable out) {
    this.model = Objects.requireNonNull(model);
    this.out = Objects.requireNonNull(out);
    this.playerList = new ArrayList<IPlayer>();
    this.playerIndex = 0;
  }

  @Override
  public void addPlayer(IPlayer player) {
    Objects.requireNonNull(player);
    if ( !playerList.contains(player)) //equals for this. we could also use as ordered set.
      this.playerList.add(player);
  }

  @Override
  public void play() {
    this.playerIndex = 0;
    int totalNumberOfPlayers = playerList.size();
    while ( this.model.gameStatus() == Status.Playing ){
      this.printBoard();
      //We need to figure out how to get the position from the player.
      try{
        IPlayer nextPlayer = this.playerList.get(playerIndex % totalNumberOfPlayers);//HUMAN, HARD_AI
        playerIndex++;//0
        Point nextPlayerPos = nextPlayer.play(this.model);
        if (nextPlayerPos == null ){
          printMessage("Tie.");
          return;
        }
        this.model.setPieceAt( nextPlayerPos.x, nextPlayerPos.y, Piece.X);
        this.printBoard();
        if ( model.gameStatus() == Status.Won){
          printMessage("Player " + nextPlayer.toString() +" won.");
          return;
        }
      }catch( Exception e){
        System.err.println("Something went wrong when playing the game: " + e.getMessage());
      }
    }
  }

  protected void printMessage(String message){
    try{
      this.out.append(message);
    }catch(IOException e){
      System.err.println("Failed to append to appendable: " + e.getMessage());
    }
  }

//  //If we want P1 to be human
//  protected Point getPositionForP1(){
//    return humanPlayer();
//  }
//
//  //If we want P2 to be an AI (computer player).
//  protected Point getPositionForP2(){
//   return AIPlayer();
//  }

  protected void printBoard(){
    //TODO: print the board to the appendable.
  }
}






