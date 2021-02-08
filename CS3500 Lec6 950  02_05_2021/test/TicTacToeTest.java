import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import model.IPlayer;
import model.ITicTacToe;
import model.IWritablePlayer;
import model.MutablePlayer;
import model.Player;
import model.TicTacToe;

public class TicTacToeTest {

  @org.junit.Test
  public void nextPlayer() {
    MutablePlayer mutablePlayer = new MutablePlayer("X");
    TicTacToe model1 = new TicTacToe( "X", "O");
    TicTacToe model2 = new TicTacToe( "X", "O");
    TicTacToe model3 = new TicTacToe( "X", "O");

    assertEquals(  5, model1.VALUE);
    model1.VALUE = 6;
    assertEquals( 5, model2.VALUE);


//    mutablePlayer.updatePlayerCode("Z");
//
//    assertEquals("", model1.toString() );




  }
}