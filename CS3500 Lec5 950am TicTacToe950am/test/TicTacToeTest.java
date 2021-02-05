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
    ITicTacToe model1 = new TicTacToe( "X", "Y" );

    mutablePlayer.updatePlayerCode("Z");

    assertEquals("", model1.toString() );




  }
}