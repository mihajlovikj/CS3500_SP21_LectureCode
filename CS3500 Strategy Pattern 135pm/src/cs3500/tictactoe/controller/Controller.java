package cs3500.tictactoe.controller;

import cs3500.tictactoe.model.Piece;
import cs3500.tictactoe.model.Status;
import cs3500.tictactoe.model.TicTacToeModel;
import cs3500.tictactoe.strategies.CompositeStrategy;
import cs3500.tictactoe.strategies.HumanStrategy;
import cs3500.tictactoe.strategies.IStrategy;
import cs3500.tictactoe.strategies.PlayACorner;
import cs3500.tictactoe.strategies.PlayAnyOpenSpace;
import cs3500.tictactoe.strategies.PlayCenter;
import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Controller implements IController{
  private final TicTacToeModel model;
  private final Appendable out;//view.
  private final List<IPlayer> playerList;
  private final Readable in;
  private final Map<Mode, IStrategy> strategyMap;
  public Controller(TicTacToeModel model, Appendable out, Readable in) {
    this.model = Objects.requireNonNull(model);
    this.out = Objects.requireNonNull(out);
    this.playerList = new ArrayList<IPlayer>();
    this.in = Objects.requireNonNull(in);
    this.strategyMap = new HashMap<>();

    this.strategyMap.putIfAbsent(Mode.EASY_AI, new PlayAnyOpenSpace());
    this.strategyMap.putIfAbsent(Mode.MEDIUM_AI, new CompositeStrategy(
                                                    new PlayCenter(),
                                                      new CompositeStrategy(
                                                        new PlayACorner(),
                                                            new PlayAnyOpenSpace())));


    //TODO populate the rest.
  }

  protected void printBoard(){
    //TODO: print the board to out.
  }

  protected void printMessage(String message){
    try{
      this.out.append(message);
    } catch (IOException e){
      System.err.println("Could not write to appendble " + message);
    }
  }

  @Override
  public void play() {
    if ( playerList.size() < 2 ){
      throw new IllegalStateException("At least two players needed..");
    }
    int currentPlayer = 0;
    int totalPlayers = playerList.size();
    //Assume there only two players.
    while ( this.model.gameStatus() == Status.Playing){ // while we can play the game.
      this.printBoard();                //1
      IPlayer player = playerList.get(currentPlayer);//player2
      currentPlayer = (currentPlayer + 1) % totalPlayers; // 2%2 = 0;


      Point playerPos = player.getPosition();
      try{
        this.model.setPieceAt(playerPos.x, playerPos.y, player.getPiece());
      }catch (Exception e){
        printMessage("Could not play in that position.");
      }
      this.printBoard();
      if ( this.model.gameStatus() == Status.Won ){
        printMessage("Player: " + player.getPiece() + " won.");
        return;
      }
    }
  }



  @Override
  public void addPlayer(IPlayer player) {
    Objects.requireNonNull(player);


    if ( !playerList.contains(player)){
      playerList.add(player); // make sure we override equals in Player.
    }
  }
}
