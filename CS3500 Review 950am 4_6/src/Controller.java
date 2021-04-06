import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Controller implements IController, IModelEventHandler {

  private final IModel model;
  private final Appendable out;
  private Set<String> currentUsers;
  public Controller(IModel model, Appendable out) {
    this.model = Objects.requireNonNull(model);
    this.out = Objects.requireNonNull(out);
    this.currentUsers = new HashSet<>();
    this.model.subscribe(this);
  }

  @Override
  public void go() {
//    //pull approach.
//    //this will not work on a single thread application.
//    //multi threaded app.
//    while ( true ){ // i feel adventerous
//      //somehow figure out if a new user has been added.
//      Set<String> newUsers = model.getUsers();
//      //currentUsers = [];
//      //newUsers = ["user1", "user2"];
//      //find the diff between currentUsers and newUsers
//      //add the new users to the log.
//      //set currentUsers = newUsers.
//    }
  }

  @Override
  public void handleUserAdded(String user) {
    try {
      this.out.append("User added: " + user + " " + new Date(System.currentTimeMillis()) + "\n");
    } catch(IOException e){

    }
  }
}
