package model;

import java.util.List;

public interface IModel extends IReadOnlyModel {
  void addUsername(IUser username);
}
