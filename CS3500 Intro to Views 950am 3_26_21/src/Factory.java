import java.util.function.Function;
import model.IModel;
import view.IGeneralView;
import view.IView;
import view.SVGView;
import view.TextView;
import view.View;

public class Factory {
  public static IView makeView(String type, Appendable appendable, IModel model){
    switch ( type ){
      case "svg":
        return new SVGView("");
      case "text":
        return new TextView(appendable);
      case "gui":
        return new View(0,0, 800, 800, 800,800);
      default:
        throw new IllegalArgumentException("Unkown type.");
    }
  }
//  public static View makeModel(String type){
//
//  }
//
//  public static TextView makeModel(String type){
//
//  }
}
