package model;

/**
 * Created by vidojemihajlovikj on 2/5/21.
 */
public enum VALUE {
  ONE(1), TWO(2), THREE(3);

  private final int value;

  private VALUE(int value){
    this.value = value;
  }

  public int getValue(){
    return this.value;
  }

  private VALUE(){
    this.value = 0;
  }

}
