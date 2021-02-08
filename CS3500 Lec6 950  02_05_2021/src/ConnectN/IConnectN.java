package ConnectN;

/**
 * Created by vidojemihajlovikj on 2/5/21.
 */
public interface IConnectN {
  int getWidth();
  int getHeight();
  int getNumPlayers();
  int getWinGoal();
  GameState getGameStat();
  int move(int who, int where);
}
