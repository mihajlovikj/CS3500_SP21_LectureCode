package view;

import java.util.List;
import model.IModel;
import model.IReadOnlyModel;
import model.IUser;

public class View implements  IView{

  @Override
  public void render(IReadOnlyModel model) {
    for ( IUser username : model.getUsernames() ){
      System.out.println(username.getName());
    }
  }
}
