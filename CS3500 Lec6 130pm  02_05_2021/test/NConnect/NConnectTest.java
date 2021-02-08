package NConnect;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by vidojemihajlovikj on 2/5/21.
 */
public class NConnectTest {
  @Test
  public void test1(){
    //INConnect nConnect = new NConnect(5,5,3, false, "X", "0");


    INConnect model = NConnect.builder().setWidth(4).setGoal(3).build();
  }

}