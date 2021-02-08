package Singleton;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by vidojemihajlovikj on 2/5/21.
 */
public class Database implements IModel {
  private final Map<String, String> map;
  private static IModel singleton = null;
  private static int numObjectsCreated = 0;

  public static IModel getDatabase(){
    if ( singleton == null ){
      singleton = new Database();
    }

    return singleton;
  }

  private Database() {
    this.map = new LinkedHashMap<>();
  }


  @Override
  public String getUser(String userId) {
    return null;
  }

  @Override
  public void addUser(String username, String userId) {

  }
}
