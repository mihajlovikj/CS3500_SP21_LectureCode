import static org.junit.Assert.assertEquals;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import model.IPlayer;
import model.ITicTacToe;
import model.NewPlayer;
import model.Player;
import model.TicTacToe;
import org.junit.Test;

public class TicTacToeTest {

  @Test
  public void createModelTestExample(){
    String [] array = new String[2];
    array[0] = "X";
    array[1] = "O";
    ITicTacToe model = new TicTacToe( array );



    //Start playing the game.
    model.move(0,0);
    model.move(1,1);

    assertEquals("", model.toString() );


  }

}