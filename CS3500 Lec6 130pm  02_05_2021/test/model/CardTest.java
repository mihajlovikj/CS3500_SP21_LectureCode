package model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by vidojemihajlovikj on 2/5/21.
 */
public class CardTest {
  @Test
  public void test1(){
    ICard card1 = new Card( Suite.HEARTS, 1);
    ICard card2 = new Card( Suite.DIAMONDS, 1);
    ICard card3 = new Card( Suite.CLUBS, 1);
    ICard card4 = new Card( Suite.SPADES, 1);

    Suite suite = card1.getSuite(); // 0x100
    suite = Suite.DIAMONDS; // 0x200
    Suite suite1 = card1.getSuite(); //0x100

    System.out.println( Suite.HEARTS );

    System.out.println( SuiteEnum.DIMAONDS );


    VALUE val1 = VALUE.ONE;

    val1.getValue();

    assertTrue(true);
  }

}