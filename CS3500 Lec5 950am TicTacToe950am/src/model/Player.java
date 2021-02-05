package model;

public class Player implements IPlayer{
  private final String playerCode;

  public Player(String playerCode) {
    if ( playerCode == null ){
      throw new IllegalArgumentException("Player code cannot be null.");
    }
    //No need for a deep copy although String is a class.
    this.playerCode = playerCode;
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }

  @Override
  public IPlayer clone() {
    return new Player(this.playerCode);
  }

  @Override
  public String toString() {
    return playerCode;
  }
}
