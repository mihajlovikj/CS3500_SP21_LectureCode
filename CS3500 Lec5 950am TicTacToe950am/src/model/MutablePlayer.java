package model;

public class MutablePlayer implements IPlayer{
  private String playerCode;

  public MutablePlayer(String playerCode){
    if (playerCode == null ){
      throw new IllegalArgumentException("Player code cannot be null");
    }

    this.playerCode = playerCode;
  }

  public void updatePlayerCode(String code) {
    if (code == null ){
      throw new IllegalArgumentException("Player code cannot be null");
    }
    this.playerCode = code;
  }



  @Override
  public String toString() {
    return this.playerCode;
  }

  @Override
  public IPlayer clone() {
    return this;
  }
}
