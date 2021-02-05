package model;

public class NewPlayer implements IPlayer{
  private String playerCode;

  public NewPlayer(String playerCode) {
    if ( playerCode == null ){
      throw new IllegalArgumentException("player code cannot be null.");
    }
    this.playerCode = playerCode;
  }

  public void updatePlayerCode(String newCode){
    if ( newCode == null ){
      throw new IllegalArgumentException("Player code cannot be null.");
    }
    this.playerCode = newCode;
  }

  //TODO: overwrite hashcode and equals and make a clone method ( why a factory clone method is a good idea ).
  @Override
  public String toString() {
    return "@" + playerCode;
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
    return this;
  }
}
