import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.IModel;
import model.IUser;
import model.Model;
import model.User;
import model.User2;
import view.IView;
import view.NewView;
import view.View;

public class Main {
  //Main should be short and to the point. It should not read from the keyboard or print to screen.
  //We are aiming for decoupling.
  public static void main(String [] args){
    //MVC -> the M is our model. What about V and C, the view and the controller.

    List<IUser> list = new ArrayList<IUser>(); //list = 0x100;
    list.add(new User( "Username1") ); //0x400
    list.add(new User2());
    IModel model = new Model(list);

    //list.get(0).setName("usr");
    IUser user0 = list.get(0); //user0 = 0x400
    user0.setName("usr"); //0x400.setName("usr");
    //0x100.clear();
    //model.usernames.clear();
    for ( IUser username : model.getUsernames() ){
      System.out.println(username.getName());
    }

    /*model.addUsername( new User("username1")); //0x100
    model.addUsername( new User("username2")); //0x200

    List<IUser> usernames = model.getUsernames();//usernames = 0x200.
    usernames.get(0).setName("changed it");




    */


  }
}
