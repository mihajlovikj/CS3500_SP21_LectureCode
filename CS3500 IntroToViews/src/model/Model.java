package model;

public class Model implements IModel{
  private String username;

  public Model(){
    username = "Undefined";
  }
  //Mutating
  @Override
  public void setUsername(String username) {
    this.username = username;
  }

  //Observer
  @Override
  public String getUsername() {
    return this.username;
  }

  //Mutating
  @Override
  public void clear() {
    this.username = "";
  }
}
