package HW2;

/**
 * Created by vidojemihajlovikj on 2/5/21.
 */
public class Card implements ICard {
  private final int value;
  private final String suite;

  public Card(int value, Suite suite) {
    if ( suite == null ){
      throw new IllegalArgumentException("Suite cannot be null");
    }

    if ( value < 0 || value > 13 ){
      throw new IllegalArgumentException("Value is outside of 1-13");
    }

    // '♦' '♥' '♠'
   if ( suite != Suite.HEARTS && suite != Suite.DIAMONDS){
      throw new IllegalArgumentException("Suite is not valid.");
   }

    this.value = value;
    this.suite = ""; //fix.
  }

  @Override
  public int getValue() {
    return value;
  }

  @Override
  public String getSuite() {
    return suite;
  }
}
