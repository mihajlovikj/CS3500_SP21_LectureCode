package model;

import java.util.Objects;

/**
 * Created by vidojemihajlovikj on 2/5/21.
 */
public class Card implements ICard{
  private final int value;
  private final Suite suite;

  //VALUE is shared amongst all objects instated from this class.
  private static int VALUE = 10;

  public Card(Suite suite, int value) {
//    if ( value <= 0 || value > 13){
//      throw new IllegalArgumentException("Value must be 1-13");
//    }

    if ( suite == null ){
      throw new IllegalArgumentException("SUite cannot be null.");
    }

//    if ( suite.equalsIgnoreCase("♣") && suite.equalsIgnoreCase("♦") ){
//      throw  new IllegalArgumentException("Suite is invalid.");
//    }

    this.value = value;
    this.suite = suite;
  }

  @Override
  public int getValue() {
    return value;
  }

  @Override
  public Suite getSuite() {
    //Don't return references to private data.
    return this.suite;
  }

  @Override
  public int hashCode(){
    return Objects.hash(this.suite, this.value);
  }
}
