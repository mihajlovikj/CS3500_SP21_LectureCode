package model;

public class User implements IUser{
  private String name;

  public User(String name) {
    if ( name == null ) throw new IllegalArgumentException("cannot be null");
    this.name = name;
  }

  @Override
  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public IUser clone() {
    return new User(this.name);
  }


}
