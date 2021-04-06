import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//IDrink theLateOfTomorrow = new Tea( new AlmondMilk( new SoyMilk() ) );
//    System.out.println(theLateOfTomorrow.getDescription() + " " + theLateOfTomorrow.getPrice());
//    View view = new View();
//    view.setVisible(true);

public class Main {
  public static void main(String [] args){
    IModel model = new Model();
    IController controller = new Controller(model, System.out);
    controller.go();
    View view = new View();
    model.subscribe(view);
    view.setVisible(true);
    //Concurent to the main program, the model is constantly getting modified.
    //Transcation.
//    ModelCreator.populateModel(model);
//    NetworkApp.processModel(model);
    //Every time the model has a transaction, i.e the model is mutated, I want to log that into a log file.
    //I want the controller the be notified, when the model is mutated.
  }
}
