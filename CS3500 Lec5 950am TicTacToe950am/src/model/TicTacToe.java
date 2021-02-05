package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.DoubleToIntFunction;
import javax.imageio.event.IIOReadProgressListener;

public class TicTacToe implements ITicTacToe{
  private IPlayer nextPlayer;
  private final List<INewPlayer> players;
  public TicTacToe(){
    players = new ArrayList<IPlayer>();
    players.add(new Player("X"));
    players.add(new Player("O"));
  }

  public TicTacToe(INewPlayer ... playerCodes){

    if ( playerCodes == null ){
      throw new IllegalArgumentException("Players cannot be null.");
    }

    if ( playerCodes.length < 2 ){
      throw new IllegalArgumentException("Players must be at least 2.");
    }

    this.players = new ArrayList<>();

    for (String playerCode : playerCodes ){
      this.players.add( new Player( playerCode) );
    }
  }


  private IPlayer _ensureNonNullPlayer(IPlayer player){
    if ( player == null ){
      throw new IllegalArgumentException("Player cannot be null.");
    }

    return player;
  }

  @Override
  public IPlayer nextPlayer() {

    return nextPlayer;
  }



  @Override
  public void move(int row, int col) {
    //..Do the move.. and update nextPlayer //


    //Update who goes next;
//    if ( nextPlayer == 'X' ){
//      nextPlayer = "0";
//    }else{
//      nextPlayer = 'X';
//    }
  }

  private void helperMethod(){
    //compute if the game is over.
//    nextPlayer = "XX";

  }

  @Override
  public String toString() {
    String output = "";
    for ( IPlayer player: players ){
      output += player.toString() + " ";
    }

    return output;
  }
}
