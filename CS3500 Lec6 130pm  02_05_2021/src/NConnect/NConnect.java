package NConnect;

import java.util.ArrayList;
import java.util.List;

import singleton.IModel;

/**
 * Created by vidojemihajlovikj on 2/5/21.
 */
public class NConnect implements INConnect {
  private final int width;
  private final int height;
  private final int goal;
  private final boolean timed;
  private final List<String> playerList;

  private NConnect(int width, int height, int goal, boolean timed, List<String> players) {
    this.width = width;
    this.height = height;
    this.goal = goal;
    this.timed = timed;
    //TODO: Still need to do error checking.
    this.playerList = players;
  }

  public static Builder builder(){
    return new Builder();
  }

  public static class Builder{
    private int width;
    private int height;
    private int goal;
    private boolean timed;
    private final List<String> playerList;

    public Builder() {
      this.width = 4;
      this.height = 5;
      this.goal = 3;
      this.timed = false;
      this.playerList = new ArrayList<String>();
    }

    public Builder setWidth(int width){
      this.width = width;
      return this;
    }

    public Builder setHeight(int height){
      this.height = height;
      return this;
    }

    public Builder setGoal(int goal){
      this.goal = goal;
      return this;
    }

    public Builder setTimed(boolean timed){
      this.timed = timed;
      return this;
    }

    public Builder addPlayer(String playerCode){
      this.playerList.add(playerCode);
      return this;
    }

    public INConnect build(){
      return new NConnect( width, height, goal, timed, playerList);
    }
  }


}
