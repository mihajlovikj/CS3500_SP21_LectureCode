package singleton;

/**
 * Created by vidojemihajlovikj on 2/5/21.
 */
public class Model implements IModel {
  private static IModel singleton = null;
  private static int modelCounter = 0;

  public static IModel getModel(){
//    if ( modelCounter < 10 ){
//      modelCounter++;
//      return new Model();
//    }else{
//      throw new IllegalStateException("Cannot create any more models.")
//    }
    if ( singleton == null ){
      singleton = new Model();
    }

    return singleton;
  }

  private Model(){
    //You still need to all the initalization.
  }

}
