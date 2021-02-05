package model;

public interface IUser extends Cloneable {
  void setName(String name);
  String getName();
  IUser clone();
}
