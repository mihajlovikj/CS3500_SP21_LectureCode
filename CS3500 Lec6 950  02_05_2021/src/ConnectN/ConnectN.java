package ConnectN;

import java.util.ArrayList;
import java.util.List;

import model.IPlayer;
import model.Player;

/**
 * Created by vidojemihajlovikj on 2/5/21.
 */
public class ConnectN implements IConnectN {
  private final int width;
  private final int height;
  private final int goal;
  private final List<IPlayer> playerList;

  private ConnectN(int width, int height, int goal, List<IPlayer> playerList) {
    if ( width < 0 || height < 0 || goal < 0 ){
      throw new IllegalArgumentException("Invalid params.");
    }

    this.width = width;
    this.height = height;
    this.goal = goal;
    //TODO: Don't do this. FIX
    this.playerList = null;
  }

  static Builder getBuilder(){
    return new Builder();
  }

  public static class Builder{
    private int width;
    private int height;
    private int goal;
    private  List<IPlayer> playerList;

    public Builder(){
      this.width = 4;
      this.height = 4;
      this.goal = 3;
      this.playerList = new ArrayList<>();
    }

    Builder setWidth(int width){
      this.width = width;
      return this;
    }

    Builder setHeight(int height){
      this.height = height;
      return this;
    }

    Builder setGoal(int goal){
      this.goal = goal;
      return this;
    }

    Builder addPlayer(String playerCode){
      this.playerList.add( new Player(playerCode));
      return this;
    }

    IConnectN build(){
      return new ConnectN(width, height, goal, playerList);
    }

  }


  @Override
  public int getWidth() {
    return 0;
  }

  @Override
  public int getHeight() {
    return 0;
  }

  @Override
  public int getNumPlayers() {
    return 0;
  }

  @Override
  public int getWinGoal() {
    return 0;
  }

  @Override
  public ConnectN.GameState getGameStat() {
    return null;
  }

  @Override
  public int move(int who, int where) {
    return 0;
  }
}
