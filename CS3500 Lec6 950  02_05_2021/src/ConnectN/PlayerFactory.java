package ConnectN;

import model.IPlayer;
import model.Player;

/**
 * Created by vidojemihajlovikj on 2/5/21.
 */
public class PlayerFactory {
  public static IPlayer makePlayer(PlayerType type){
    switch(type){
      case RegularPlayer:
        return new Player();
      case AdvancedPlayer:
        return new AdancedPlayer();
    }
  }
}
