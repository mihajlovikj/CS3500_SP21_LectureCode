package model;

import java.util.List;

public interface IReadOnlyModel {
  String getUsername(int index) throws IndexOutOfBoundsException;
  List<IUser> getUsernames();
}
