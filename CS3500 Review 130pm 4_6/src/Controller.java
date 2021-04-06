import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Controller implements IController, ModelAddUserHandler, ModelDeleteUserHandler{
  private final IModel model;
  private final Appendable out;
  private Set<String> currentUsers;
  public Controller(IModel model, Appendable out) {
    this.model = Objects.requireNonNull( model );
    this.out = Objects.requireNonNull( out );
    this.currentUsers = new HashSet<>();

  }



  @Override
  public void go() {
    //How can get updates?// pull approach, subscribe
    //pull approach = road trip approach when you were little (i.e are we there yet)?
    //we are feeling adventerous.
    //if the controller were to live in its own thread.
    //this could work.

//    while ( true ){
//      Set<String> newusers = model.getAllUsers();
//      //look at the diff between the current users and newUsers
//      //figure out which are the new users.
//      //foreach ( newuser ){
//      // out.append("new user added.");
//      currentUsers = newusers;
//    }
  }


  @Override
  public void handleAddUser() {

  }

  @Override
  public void handleDeleteUser() {

  }
}
