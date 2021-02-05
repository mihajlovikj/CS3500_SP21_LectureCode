import static org.junit.Assert.*;

import model.IModel;
import model.Model;

public class ModelTest {
  IModel model;
  @org.junit.Before
  public void setUp() throws Exception {
    model = new Model();
  }

  @org.junit.Test
  public void getUsername() {
  }

  @org.junit.Test
  public void addUsername() {
//    model.addUsername("test1");
//    assertEquals("test1", model.getUsername(0));
  }

  @org.junit.Test
  public void getUsernames() {
  }
}