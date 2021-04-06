import java.util.Set;

public interface IModel {
  void addUser(String user);
  Set<String> getUsers();
  void subscribe(IModelEventHandler modelEventHandler);
}
