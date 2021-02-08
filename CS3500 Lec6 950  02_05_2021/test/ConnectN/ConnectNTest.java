package ConnectN;

import static org.junit.Assert.*;

/**
 * Created by vidojemihajlovikj on 2/5/21.
 */
public class ConnectNTest {
  public void test1(){
    //IConnectN model = new ConnectN()
    IConnectN model = ConnectN.getBuilder().setGoal(2).setHeight(4).build();
  }


  //IPLayer player = PlayerFactory.makePlayer( PlayerType.AdvancedPlayer );
}