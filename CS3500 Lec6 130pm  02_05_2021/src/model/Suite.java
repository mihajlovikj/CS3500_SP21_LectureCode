package model;

/**
 * Created by vidojemihajlovikj on 2/5/21.
 */
public final class Suite {
  private final String stringValue;

  public static final Suite HEARTS = new Suite("HEARTS");//0x100
  public static final Suite DIAMONDS = new Suite("DIAMONDS"); //0x200
  public static final Suite CLUBS = new Suite("CLUBS");//0x300
  public static final Suite SPADES = new Suite("SPADES"); //0x400

  private Suite(String string){
    this.stringValue = string;
  }

  @Override
  public String toString(){
    return stringValue;
  }

  private Suite(){
    stringValue = "";
  };
}
