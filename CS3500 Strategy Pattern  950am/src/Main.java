import cs3500.tictactoe.controller.Controller;
import cs3500.tictactoe.controller.IController;
import cs3500.tictactoe.controller.Player;
import cs3500.tictactoe.controller.PlayerType;
import cs3500.tictactoe.controller.strategies.CombinedStrategy;
import cs3500.tictactoe.controller.strategies.HumanStrategy;
import cs3500.tictactoe.controller.strategies.PlayAnyOpenSpace;
import cs3500.tictactoe.controller.strategies.PlayCenter;
import cs3500.tictactoe.controller.strategies.PlayCorner;
import cs3500.tictactoe.controller.strategies.TryToBlock;
import cs3500.tictactoe.controller.strategies.TryToWin;
import cs3500.tictactoe.model.Piece;
import cs3500.tictactoe.model.TTTModelImpl;
import cs3500.tictactoe.model.TicTacToeModel;
import java.io.InputStreamReader;
import java.io.StringReader;

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
    IController controller = new Controller(model, new StringBuilder());
    controller.addPlayer( new Player(Piece.X, new HumanStrategy(new InputStreamReader(System.in))));
    controller.addPlayer( new Player(Piece.O, new CombinedStrategy( new TryToWin(), new CombinedStrategy( new TryToBlock(), new CombinedStrategy(new PlayCenter(), new CombinedStrategy(new PlayCorner(), new PlayAnyOpenSpace()))))));
    controller.play();
  }
}