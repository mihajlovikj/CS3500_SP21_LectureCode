import java.util.Set;

public interface IModel {
  void addUser(String user);
  Set<String> getAllUsers();
  void subscribeAddUser(ModelAddUserHandler controller);
  void subscribeDeleteUser(ModelDeleteUserHandler controller);
}
