package Singleton;

import org.junit.Test;

import javax.xml.crypto.Data;

import static org.junit.Assert.*;

/**
 * Created by vidojemihajlovikj on 2/5/21.
 */
public class DatabaseTest {
  @Test
  public void test1(){
    IModel db = Database.getDatabase();

    db.addUser("us1", "id1");
    db.addUser("us2", "id2");

    IModel db1 = Database.getDatabase();

    assertTrue(true);
  }

}