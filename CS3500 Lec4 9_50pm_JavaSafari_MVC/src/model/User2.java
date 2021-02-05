package model;

public class User2 implements IUser{

  @Override
  public void setName(String name) {

  }

  @Override
  public String getName() {
    return null;
  }

  @Override
  public IUser clone() {
    return new User2();
  }
}
