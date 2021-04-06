import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Model implements IModel{
  private final Set<String> users;
  private final List<IModelEventHandler> subscribers;
  public Model() {
    this.users = new HashSet<>();
    this.subscribers = new ArrayList<>();
  }



  @Override
  public void addUser(String user) {
    this.users.add(Objects.requireNonNull(user));
    for ( IModelEventHandler subscriber : subscribers ){

    }

  }

  @Override
  public Set<String> getAllUsers() {
    return new HashSet<>(this.users);
  }

  @Override
  public void subscribeAddUser(ModelAddUserHandler controller) {
    //Two lists.
  }

  @Override
  public void subscribeDeleteUser(ModelDeleteUserHandler controller) {

  }


}
