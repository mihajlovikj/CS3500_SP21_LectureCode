package singleton;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by vidojemihajlovikj on 2/5/21.
 */
public class ModelTest {
  @Test
  public void test1(){
    IModel modelRef = Model.getModel();
    IModel modelRef1 = Model.getModel();
    assertEquals("", "");
  }

}