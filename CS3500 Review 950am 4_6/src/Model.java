import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Model implements IModel{
  private final List<String> users;
  private final List<IModelEventHandler> modelEventHandlers;
  public Model(){
    this.users = new ArrayList<>();
    this.modelEventHandlers = new ArrayList<>();
  }

  public void subscribe(IModelEventHandler modelEventHandler){
    this.modelEventHandlers.add( Objects.requireNonNull(modelEventHandler));
  }

  @Override
  public void addUser(String user) {
    this.users.add(Objects.requireNonNull(user) );
    //this is a tight coupling because the model has reference to the controller.

    for ( IModelEventHandler subscriber : modelEventHandlers ){
      subscriber.handleUserAdded(user);
    }

  }

  @Override
  public Set<String> getUsers() {
    return new HashSet<>(this.users);
  }
}
