package model;

public class Player implements IPlayer{
  private final String playerCode;

  public Player(String playerCode) {
    if ( playerCode == null ){
      throw new IllegalArgumentException("player code cannot be null.");
    }
    this.playerCode = playerCode;
  }

  //TODO: overwrite hashcode and equals and make a clone method ( why a factory clone method is a good idea ).
  @Override
  public String toString() {
    return playerCode;
  }

  @Override
  public boolean equals(Object obj) {
    //TODO: implement this properly.
   return false;
  }

  @Override
  public int hashCode() {
    //TODO: implement hashcode.
    return super.hashCode();
  }

  @Override
  public IPlayer clone() {
    return new Player( this.playerCode );
  }
}
