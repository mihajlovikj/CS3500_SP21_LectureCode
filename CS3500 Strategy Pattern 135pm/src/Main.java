import cs3500.tictactoe.controller.Controller;
import cs3500.tictactoe.controller.IController;
import cs3500.tictactoe.controller.Mode;
import cs3500.tictactoe.controller.Player;
import cs3500.tictactoe.model.Piece;
import cs3500.tictactoe.model.TTTModelImpl;
import cs3500.tictactoe.model.TicTacToeModel;
import cs3500.tictactoe.strategies.CompositeStrategy;
import cs3500.tictactoe.strategies.HumanStrategy;
import cs3500.tictactoe.strategies.PlayACorner;
import cs3500.tictactoe.strategies.PlayAnyOpenSpace;
import cs3500.tictactoe.strategies.PlayCenter;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) {
    int h = 3;
    int w = 3;
    int g = 3;
    if (args.length == 3) {
      h = Integer.parseInt(args[0]);
      w = Integer.parseInt(args[1]);
      g = Integer.parseInt(args[2]);
    }
    TicTacToeModel model = new TTTModelImpl.Builder().setHeight(h).setWidth(w).setGoal(g).build();
    IController controller = new Controller( model, new StringBuilder(), new InputStreamReader( System.in));
    controller.addPlayer( new Player(Piece.X, new HumanStrategy(new InputStreamReader( System.in))));
    controller.addPlayer( new Player(Piece.O, new CompositeStrategy( new PlayCenter(), new CompositeStrategy( new PlayACorner(), new PlayAnyOpenSpace()))));
    // we want a MEDIUM_HARD
    controller.play();
  }
}