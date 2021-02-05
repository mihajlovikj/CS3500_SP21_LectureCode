package view;

import java.util.List;
import model.IModel;
import model.IReadOnlyModel;

public interface IView {
  //Disadvantage to this approach.
  void render(IReadOnlyModel model);
}