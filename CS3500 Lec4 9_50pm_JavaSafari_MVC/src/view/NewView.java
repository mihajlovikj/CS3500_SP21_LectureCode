package view;

import java.util.List;
import model.IModel;
import model.IReadOnlyModel;
import model.IUser;

public class NewView implements  IView{

  @Override
  public void render(IReadOnlyModel model) {

    System.out.println("--------");
    for ( IUser username : model.getUsernames() ){
      System.out.println(username);
    }
    System.out.println("--------");
  }
}
